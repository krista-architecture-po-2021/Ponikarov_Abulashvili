package provider;

import java.util.List;

public interface IProvider {
    public <T> T get(String entityName, int id);

    public <T> List<T> getAll(String entityName);

    public <T> void add(String entityName, T entity);

    public <T> void update(String entityName, int id, T entity);

    public void delete(String entityName, int id);
}
