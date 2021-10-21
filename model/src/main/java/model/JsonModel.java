package model;

import dao.CategoriesDao;
import dao.NewsDao;
import provider.IProvider;
import provider.JsonProvider;

public class JsonModel extends ModelFactory {
    @Override
    public NewsDao getNewsDao() {
        return new NewsDao(new JsonProvider());
    }

    @Override
    public CategoriesDao getCategoriesDao() {
        return new CategoriesDao(new JsonProvider());
    }
}
