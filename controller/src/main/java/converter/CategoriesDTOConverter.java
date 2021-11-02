package converter;

import categoryController.Category;
import dto.CategoryDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriesDTOConverter {
    public static CategoryDTO createCategoryDTO(Category categoryBO) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryBO.getId());
        categoryDTO.setName(categoryBO.getName());

        return categoryDTO;
    }

    public static Category createCategoryBO(CategoryDTO categoryDTO) {
        Category categoryBO = new Category();
        categoryBO.setId(categoryDTO.getId());
        categoryBO.setName(categoryDTO.getName());

        return categoryBO;
    }

    public static List<CategoryDTO> createCategoriesDTOList(List<Category> categoriesBOList) {
        return categoriesBOList.stream().
                map(CategoriesDTOConverter::createCategoryDTO).collect(Collectors.toList());
    }
}
