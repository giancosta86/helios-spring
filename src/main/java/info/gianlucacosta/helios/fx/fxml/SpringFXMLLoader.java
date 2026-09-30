package info.gianlucacosta.helios.fx.fxml;

import javafx.fxml.FXMLLoader;
import javafx.util.Callback;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * An FXML loader that instantiates its controllers by retrieving them from the
 * same Spring container into which this class itself was registered
 */
public class SpringFXMLLoader extends FXMLLoader implements ApplicationContextAware {

    private ApplicationContext context;

    public SpringFXMLLoader() {
        setControllerFactory(new Callback<Class<?>, Object>() {
            @Override
            public Object call(Class<?> requestedControllerClass) {
                return context.getBean(requestedControllerClass);
            }

        });
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

}
