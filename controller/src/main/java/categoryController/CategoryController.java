package categoryController;

import cache.Cache;
import converter.CategoriesDTOConverter;
import dto.CategoryDTO;

import java.util.List;

public class CategoryController implements ICategoryController{
    private final Cache cache = Cache.getInstance();

    @Override
    public List<CategoryDTO> getCategoryList() {
        return CategoriesDTOConverter.createCategoriesDTOList(cache.getCategories());
    }

    @Override
    public void addCategory(CategoryDTO categoryDTO){
        cache.addCategory(CategoriesDTOConverter.createCategoryBO(categoryDTO));
    }

    @Override
    public void updateCategory(Integer id, CategoryDTO categoryDTO) {
        cache.updateCategory(id, CategoriesDTOConverter.createCategoryBO(categoryDTO));
    }

    @Override
    public void deleteCategory(Integer id) {
        cache.deleteCategory(id);
    }
}
