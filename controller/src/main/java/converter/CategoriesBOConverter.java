package converter;

import categoryController.Category;
import model.ModelFactory;
import newsController.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CategoriesBOConverter {
    ModelFactory dataProvider;

    public CategoriesBOConverter(ModelFactory dataProvider) {
        this.dataProvider = dataProvider;
    }

    public Category createCategoryBO(dataobject.Category categoryDO) {
        Category category = new Category();
        category.setId(categoryDO.getId());
        category.setName(categoryDO.getName());

        return category;
    }

    public dataobject.Category createCategoryDO(Category categoryBO) {
        dataobject.Category categoryDO = new dataobject.Category();
        categoryDO.setId(categoryBO.getId());
        categoryDO.setName(categoryBO.getName());

        return categoryDO;
    }

    public List<Category> createCategoriesBOList(List<dataobject.Category> categoriesDO) {
        return categoriesDO.stream().map(this::createCategoryBO).collect(Collectors.toList());
    }

    private int getCategoryId(String categoryName) {
        for (dataobject.Category category: dataProvider.getCategoriesDao().getAll()) {
            if (Objects.equals(category.getName(), categoryName)) {
                return category.getId();
            }
        }

        return 0;
    }
}
