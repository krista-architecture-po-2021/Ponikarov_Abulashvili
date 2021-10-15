package provider;

import entity.IEntity;

import java.util.List;

public class ArrayProvider implements IProvider {


    @Override
    public <T> T get(String entityName, int id) {
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
    public <T> void update(String entityName, T entity) {

    }

    @Override
    public void delete(String entityName, int id) {

    }
}
