package dao;

import entity.NewsCategory;

import java.util.List;

public interface INewsCategoryDao {
    NewsCategory get(int id);

    List<NewsCategory> getAll();

    void add(NewsCategory category);

    void update(int id, String name);

    void delete(int id);
}
