package provider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Categories;
import entity.IEntity;
import entity.News;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JSonProvider implements IProvider{
    ObjectMapper objectMapper;

    public JSonProvider(){
        objectMapper = new ObjectMapper();
    }

    @Override
    public <T extends IEntity> T get(String entityName, int id) {
        List<T> entities = readJson(entityName);

        if (entities != null) {
            for (T entity : entities) {
                if (Objects.equals(entity.getId(), id)) {
                    return entity;
                }
            }
        }

        return null;
    }

    @Override
    public <T> List<T> getAll(String entityName) {
        return readJson(entityName);
    }

    @Override
    public <T> void add(String entityName, T entity) {
        List<T> entities = readJson(entityName);

        if (entities == null){
            entities = new ArrayList<>();
        }

        entities.add(entity);

        writeJson(entities, entityName);
    }

    @Override
    public <T extends IEntity> void update(String entityName, T entity) {
        List<T> entities = readJson(entityName);

        if (entities != null){
            for (T curEntity: entities){
                if (Objects.equals(curEntity.getId(), entity.getId())) {
                    curEntity.setName(entity.getName());

                    if ("news".equals(entityName)){
                        News curNews = (News)curEntity;
                        curNews.setContent(((News)entity).getContent());
                    }
                }
            }

            writeJson(entities, entityName);
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


    private <T> List<T> readJson(String filePath){
        try {
            return objectMapper.readValue(new File(filePath + ".json"), new TypeReference<List<T>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private <T> void writeJson(List<T> entities, String filePath){
        try (FileWriter fileWriter = new FileWriter(filePath + ".json", false)){
            fileWriter.write(objectMapper.writeValueAsString(entities));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
