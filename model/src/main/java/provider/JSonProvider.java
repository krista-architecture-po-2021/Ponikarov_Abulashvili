package provider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Categories;
import entity.IEntity;

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

    private List<T> readJson(String filePath){
        try {
            return objectMapper.readValue(new File(filePath), new TypeReference<List<T>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void writeJson(List<T> entities, String filePath){
        try (FileWriter fileWriter = new FileWriter(filePath + ".json", false)){
            fileWriter.write(objectMapper.writeValueAsString(entities));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
