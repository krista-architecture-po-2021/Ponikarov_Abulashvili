package cache;


import categoryController.Category;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    private static Cache INSTANCE;

    private List<Category> categories;

    private Cache() {
        categories = new ArrayList<>();
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
        return categories;
    }

    public void addCategory(Category category) {categories.add(category);}

    public void refreshCategory(Integer id, String newName) {
        for (Category category: categories) {
            if (category.getId().equals(id)) {
                category.setName(newName);
            }
        }
    }

    public void deleteCategory(Integer id) {
        categories.removeIf(newsCategory -> newsCategory.getId().equals(id));
    }
}
