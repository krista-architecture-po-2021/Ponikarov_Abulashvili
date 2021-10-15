package provider;

import entity.IEntity;

import java.util.List;

public interface IProvider {
    public <T extends IEntity> T get(String entityName, int id);

    public <T> List<T> getAll(String entityName);

    public <T> void add(String entityName, T entity);

    public <T extends IEntity> void update(String entityName, T entity);

    public <T extends IEntity> void delete(String entityName, int id);
}
