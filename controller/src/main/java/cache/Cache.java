package cache;


import categoryController.NewsCategory;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    private static Cache INSTANCE;

    private List<NewsCategory> categories;

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

    public List<NewsCategory> getCategories() {
        return categories;
    }

    public void addCategory(NewsCategory category) {categories.add(category);}

    public void refreshCategory(Integer id, String newName) {
        for (NewsCategory category: categories) {
            if (category.getId().equals(id)) {
                category.setName(newName);
            }
        }
    }

    public void deleteCategory(Integer id) {
        categories.removeIf(newsCategory -> newsCategory.getId().equals(id));
    }
}
