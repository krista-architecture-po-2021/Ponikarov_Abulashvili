package provider;

import dataobject.Category;
import dataobject.IEntity;
import dataobject.News;

import java.util.*;

public class ArrayProvider implements IProvider {
    Map<String, List<IEntity>> data;

    public  ArrayProvider(){
        data = new HashMap<>();
    }

    @Override
    public <T extends IEntity> T get(String entityName, int id) {
        return (T) getElementById(data.get(entityName), id);
    }

    @Override
    public <T extends IEntity> List<T> getAll(String entityName) {
        return (List<T>) data.get(entityName);
    }

    @Override
    public <T extends IEntity> void add(String entityName, T entity) {
        data.get(entityName).add(entity);
    }

    @Override
    public <T extends IEntity> void update(String entityName, int id, T entity) {
        IEntity curEntity = getElementById(data.get(entityName), id);

        if (curEntity != null) {
            curEntity.update(entity);
        }
    }

    @Override
    public <T extends IEntity> void delete(String entityName, int id) {
        data.get(entityName).removeIf(entity -> Objects.equals(entity.getId(), id));
    }

    private <T extends IEntity> T getElementById(List<T> elements, int id){
        for (T element: elements){
            if (Objects.equals(element.getId(), id)){
                return element;
            }
        }

        return null;
    }
}
