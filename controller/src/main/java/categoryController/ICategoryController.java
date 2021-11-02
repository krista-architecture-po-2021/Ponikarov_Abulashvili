package categoryController;

import dto.CategoryDTO;

import java.util.List;

public interface ICategoryController {
    public List<CategoryDTO> getCategoryList();
    public void addCategory(CategoryDTO categoryDTO);
    public void updateCategory(Integer id, CategoryDTO categoryDTO);
    public void deleteCategory(Integer id);
}
