package provider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataobject.IEntity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JsonProvider implements IProvider {
    ObjectMapper objectMapper;

    public JsonProvider(){
        objectMapper = new ObjectMapper();
    }

    @Override
    public <T extends IEntity> T get(String entityName, int id) {
        List<T> entities = readJson(entityName);

        if (entities != null) {
            return getElementById(entities, id);
        }

        return null;
    }

    @Override
    public <T extends IEntity> List<T> getAll(String entityName) {
        return readJson(entityName);
    }

    @Override
    public <T extends IEntity> void add(String entityName, T entity) {
        List<T> entities = readJson(entityName);

        if (entities == null){
            entities = new ArrayList<>();
        }

        entities.add(entity);

        writeJson(entities, entityName);
    }

    @Override
    public <T extends IEntity> void update(String entityName, int id, T dataObject) {
        List<T> entities = readJson(entityName);

        if (entities != null){
            T entity = getElementById(entities, id);

            if (entity != null){
                entity.update(dataObject);
            }
        }
    }

    @Override
    public <T extends IEntity> void delete(String entityName, int id) {
        List<T> entities = readJson(entityName);

        if (entities != null) {
            entities.removeIf(entity -> Objects.equals(entity.getId(), id));

            writeJson(entities, entityName);
        }
    }

    private <T extends IEntity> T getElementById(List<T> elements, int id){
        for (T element: elements){
            if (Objects.equals(element.getId(), id)){
                return element;
            }
        }

        return null;
    }

    private <T extends IEntity> List<T> readJson(String filePath){
        try {
            return objectMapper.readValue(new File(filePath + ".json"), new TypeReference<List<T>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private <T extends IEntity> void writeJson(List<T> entities, String filePath){
        try (FileWriter fileWriter = new FileWriter(filePath + ".json", false)){
            fileWriter.write(objectMapper.writeValueAsString(entities));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
