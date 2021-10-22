package provider;

import dataobject.IEntity;

import java.util.List;

public interface IProvider {
    public <T extends IEntity> T get(String entityName, int id);

    public <T extends IEntity> List<T> getAll(String entityName);

    public <T extends IEntity> void add(String entityName, T entity);

    public <T extends IEntity> void update(String entityName, int id, T entity);

    public <T extends IEntity> void delete(String entityName, int id);
}
