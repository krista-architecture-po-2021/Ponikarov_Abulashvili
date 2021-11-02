package cache;


import categoryController.Category;
import converter.CategoriesBOConverter;
import model.ModelFactory;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    private final ModelFactory categoryProvider;
    private final CategoriesBOConverter boConverter;

    private static Cache INSTANCE;

    private final List<Category> categories;

    private Cache() {
        categories = new ArrayList<>();
        categoryProvider = ModelFactory.getModel(ModelFactory.JSON);
        boConverter = new CategoriesBOConverter(categoryProvider);
    }

    public static Cache getInstance() {
        if (INSTANCE == null) {
            synchronized (Cache.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Cache();
                }
            }
        }

        return INSTANCE;
    }

    public List<Category> getCategories() {
        if (categories.isEmpty()) {
            categories.addAll(boConverter.createCategoriesBOList(categoryProvider.
                    getCategoriesDao().getAll()));
        }

        return categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
        categoryProvider.getCategoriesDao().add(boConverter.createCategoryDO(category));
    }

    public void updateCategory(Integer id, Category category) {
        for (Category curCategory: categories) {
            if (curCategory.getId().equals(id)) {
                curCategory.setName(category.getName());
                categoryProvider.getCategoriesDao().update(id, boConverter.createCategoryDO(category));
            }
        }
    }

    public void deleteCategory(Integer id) {
        categories.removeIf(newsCategory -> newsCategory.getId().equals(id));
        categoryProvider.getCategoriesDao().delete(id);
    }
}
