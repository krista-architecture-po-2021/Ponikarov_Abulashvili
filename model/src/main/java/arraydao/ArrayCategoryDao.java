package arraydao;

import dao.Dao;
import entity.Categories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ArrayCategoryDao implements Dao<Categories> {
    List<Categories> categories;

    public ArrayCategoryDao(){
        categories = new ArrayList<>();
    }

    @Override
    public Categories get(int id) {
        for (Categories categories : this.categories){
            if (Objects.equals(categories.getId(), id)){
                return categories;
            }
        }

        return null;
    }

    @Override
    public List<Categories> getAll() {
        return categories;
    }

    @Override
    public void add(Categories category) {
        categories.add(category);
    }

    @Override
    public void update(int id, String name) {
        for (Categories categories : this.categories){
            if (Objects.equals(categories.getId(), id)){
                categories.setName(name);
            }
        }
    }

    @Override
    public void delete(int id) {
        categories.removeIf(newsCategory -> Objects.equals(newsCategory.getId(), id));
    }
}
