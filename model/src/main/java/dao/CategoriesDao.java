package dao;

import entity.Category;
import provider.IProvider;

import java.util.List;

public class CategoriesDao implements Dao<Category> {
    private IProvider provider;
    final static private String entityName = "categories";

    public CategoriesDao(IProvider provider) {
        this.provider = provider;
    }

    @Override
    public Category get(int id) {
        return provider.get(entityName, id);
    }

    @Override
    public List<Category> getAll() {
        return provider.getAll(entityName);
    }

    @Override
    public void add(Category category) {
        provider.add(entityName, category);
    }

    @Override
    public void update(int id, Category category) {
        provider.update(entityName, id, category);
    }

    @Override
    public void delete(int id) {
        provider.delete(entityName, id);
    }
}
