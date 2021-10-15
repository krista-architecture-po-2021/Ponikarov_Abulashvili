package jsondao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Dao;
import entity.Categories;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class JsonCategoryDao implements Dao<Categories> {
    ObjectMapper objectMapper;

    private static final String filePath = "categories.json";

    public JsonCategoryDao() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public Categories get(int id) {
        List<Categories> categories = readCategories();

        if (categories != null) {
            for (Categories category : categories) {
                if (Objects.equals(category.getId(), id)) {
                    return category;
                }
            }
        }

        return null;
    }

    @Override
    public List<Categories> getAll() {
        return readCategories();
    }

    @Override
    public void add(Categories category) {
        List<Categories> categories = readCategories();

        if (categories != null){
            categories.add(category);

            writeCategories(categories);
        }
    }

    @Override
    public void update(int id, String name) {
        List<Categories> categories = readCategories();

        if (categories != null){
            for (Categories category: categories){
                if (Objects.equals(category.getId(), id)) {
                    category.setName(name);
                }
            }

            writeCategories(categories);
        }
    }

    @Override
    public void delete(int id) {
        List<Categories> categories = readCategories();

        if (categories != null) {
            categories.removeIf(category -> Objects.equals(category.getId(), id));

            writeCategories(categories);
        }
    }

    private List<Categories> readCategories(){
        try {
            return objectMapper.readValue(filePath, new TypeReference<List<Categories>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void writeCategories(List<Categories> categories){
        try {
            objectMapper.writeValue(new File(filePath), categories);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
