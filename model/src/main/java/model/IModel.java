package model;

import dao.INewsCategoryDao;
import dao.INewsDao;

public interface IModel {
    INewsDao getNewsDao();
    INewsCategoryDao getNewsCategoryDao();
    INewsDao getFilteredNewsDao(INewsCategoryDao newsCategoryDao);
}
