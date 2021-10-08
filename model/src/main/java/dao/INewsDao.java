package dao;

import entity.News;

import java.util.List;

public interface INewsDao {
    News get(int id);

    List<News> getAll();

    void add(News news);

    void update(int id, String content);

    void delete(int id);
}
