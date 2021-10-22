package categoryController;

import cache.Cache;
import categorydto.CategoryWithNewsDTO;

import java.util.List;

public class CategoryController implements ICategoryController{
    private Cache cache = Cache.getInstance();

    @Override
    public List<Category> getCategoryList() {
        return cache.getCategories();
    }

    @Override
    public void addCategory(Category category) {
        cache.addCategory(category);
    }

    @Override
    public void refreshCategory(Integer id, String newName) {
        cache.refreshCategory(id, newName);
    }

    @Override
    public void deleteCategory(Integer id) {
        cache.deleteCategory(id);
    }

    @Override
    public CategoryWithNewsDTO getCategoryWithNews(List<Category> categories) {
        return null;
    }
}
