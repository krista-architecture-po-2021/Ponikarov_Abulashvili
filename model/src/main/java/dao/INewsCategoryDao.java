package dao;

import entity.Categories;

import java.util.List;

public interface INewsCategoryDao {
    Categories get(int id);

    List<Categories> getAll();

    void add(Categories category);

    void update(int id, String name);

    void delete(int id);
}
