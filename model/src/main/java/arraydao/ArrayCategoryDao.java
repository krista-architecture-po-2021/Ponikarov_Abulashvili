package arraydao;

import dao.INewsCategoryDao;
import entity.NewsCategory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ArrayCategoryDao implements INewsCategoryDao {
    List<NewsCategory> categories;

    public ArrayCategoryDao(){
        categories = new ArrayList<>(Arrays.asList(new NewsCategory(1, "Спорт"),
                new NewsCategory(2, "Политика")));
    }

    @Override
    public NewsCategory get(int id) {
        for (NewsCategory newsCategory: categories){
            if (Objects.equals(newsCategory.getId(), id)){
                return newsCategory;
            }
        }

        return null;
    }

    @Override
    public List<NewsCategory> getAll() {
        return categories;
    }

    @Override
    public void add(NewsCategory category) {
        categories.add(category);
    }

    @Override
    public void update(int id, String name) {
        for (NewsCategory newsCategory: categories){
            if (Objects.equals(newsCategory.getId(), id)){
                newsCategory.setName(name);
            }
        }
    }

    @Override
    public void delete(int id) {
        categories.removeIf(newsCategory -> Objects.equals(newsCategory.getId(), id));
    }
}
