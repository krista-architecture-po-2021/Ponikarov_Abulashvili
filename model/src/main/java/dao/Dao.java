package dao;

import java.util.List;

public interface Dao <T> {
    T get(int id);

    List<T> getAll();

    void add(T entity);

    void update(int id, T entity);

    void delete(int id);
}
