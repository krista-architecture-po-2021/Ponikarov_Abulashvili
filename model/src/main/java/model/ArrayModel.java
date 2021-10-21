package model;

import dao.CategoriesDao;
import dao.NewsDao;
import provider.ArrayProvider;
import provider.IProvider;

public class ArrayModel extends ModelFactory {
    @Override
    public NewsDao getNewsDao() {
        return new NewsDao(new ArrayProvider());
    }

    @Override
    public CategoriesDao getCategoriesDao() {
        return new CategoriesDao(new ArrayProvider());
    }
}
