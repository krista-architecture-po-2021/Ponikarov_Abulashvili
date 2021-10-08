package jsondao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.INewsCategoryDao;
import entity.NewsCategory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class JsonCategoryDao implements INewsCategoryDao {
    ObjectMapper objectMapper;

    private static final String filePath = "categories.json";

    public JsonCategoryDao() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public NewsCategory get(int id) {
        List<NewsCategory> categories = readCategories();

        if (categories != null) {
            for (NewsCategory category : categories) {
                if (Objects.equals(category.getId(), id)) {
                    return category;
                }
            }
        }

        return null;
    }

    @Override
    public List<NewsCategory> getAll() {
        return readCategories();
    }

    @Override
    public void add(NewsCategory category) {
        List<NewsCategory> categories = readCategories();

        if (categories != null){
            categories.add(category);

            writeCategories(categories);
        }
    }

    @Override
    public void update(int id, String name) {
        List<NewsCategory> categories = readCategories();

        if (categories != null){
            for (NewsCategory category: categories){
                if (Objects.equals(category.getId(), id)) {
                    category.setName(name);
                }
            }

            writeCategories(categories);
        }
    }

    @Override
    public void delete(int id) {
        List<NewsCategory> categories = readCategories();

        if (categories != null) {
            categories.removeIf(category -> Objects.equals(category.getId(), id));

            writeCategories(categories);
        }
    }

    private List<NewsCategory> readCategories(){
        try {
            return objectMapper.readValue(filePath, new TypeReference<List<NewsCategory>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void writeCategories(List<NewsCategory> categories){
        try {
            objectMapper.writeValue(new File(filePath), categories);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
