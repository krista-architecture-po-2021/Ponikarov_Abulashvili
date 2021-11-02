import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Web-приложение в котором регистрируются все ресурсы.
 */
public class WebApplication extends Application {
    /**
     * Возвращает список всех ресурсов web-приложения.
     * @return список всех ресурсов web-приложения.
     */
    @Override
    public Set<Object> getSingletons() {
        Set<Object> resources = new HashSet<>();
        resources.add(new AuthorRest());
        resources.add(new AdminRest());
        resources.add(new UserRest());
        return resources;
    }
}
