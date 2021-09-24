package categoryController;

import java.util.List;

public interface ICategoryController {
    public List<NewsCategory> getCategoryList();
    public void addCategory(NewsCategory news);
    public void refreshCategory(Integer id, String newName);
    public void deleteCategory(Integer id);
}
