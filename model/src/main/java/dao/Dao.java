package dao;

import java.util.List;

public interface Dao <T> {
    T get(int id);

    List<T> getAll();

    void add(T category);

    void update(int id, String name);

    void delete(int id);
}
