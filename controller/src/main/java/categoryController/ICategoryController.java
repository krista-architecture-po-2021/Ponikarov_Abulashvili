package categoryController;

import categorydto.CategoryWithNewsDTO;

import java.util.List;

public interface ICategoryController {
    public List<Category> getCategoryList();
    public void addCategory(Category news);
    public void refreshCategory(Integer id, String newName);
    public void deleteCategory(Integer id);
    public CategoryWithNewsDTO getCategoryWithNews(List<Category> categories);
}
