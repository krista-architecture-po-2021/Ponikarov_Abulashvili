package model;

import dao.CategoriesDao;
import dao.NewsDao;

public abstract class ModelFactory {
    private static final int JSON = 1;
    private static final int ARRAY = 2;

    public abstract NewsDao getNewsDao();
    public abstract CategoriesDao getCategoriesDao();

    public static ModelFactory getModel(int value) {
        if (value == JSON) return new JsonModel();
        return new ArrayModel();
    }
}
