package model;

import dao.INewsCategoryDao;
import dao.INewsDao;

public abstract class ModelFactory {
    private static final int JSON = 1;
    private static final int DB = 2;

    public abstract INewsDao getNewsDao();
    public abstract INewsCategoryDao getCategoriesDao();

//    public static ModelFactory getModel(int value) {
//        if (value == JSON) return new JsonModel();
//        return new DbModel();
//    }
}
