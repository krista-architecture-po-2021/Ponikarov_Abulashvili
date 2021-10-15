package provider;

import entity.IEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayProvider implements IProvider {

    @Override
    public <T extends IEntity> T get(String entityName, int id) {
        return null;
    }

    @Override
    public <T> List<T> getAll(String entityName) {
        return null;
    }

    @Override
    public <T> void add(String entityName, T entity) {

    }

    @Override
    public <T extends IEntity> void update(String entityName, T entity) {

    }

    @Override
    public <T extends IEntity> void delete(String entityName, int id) {

    }
}
