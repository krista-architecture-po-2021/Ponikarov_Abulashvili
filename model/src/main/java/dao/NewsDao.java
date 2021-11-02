package dao;

import dataobject.News;
import provider.IProvider;

import java.util.List;

public class NewsDao implements Dao<News> {
    private IProvider provider;
    final static private String entityName = "news";

    public NewsDao(IProvider provider) {
        this.provider = provider;
    }

    @Override
    public News get(int id) {
        return provider.get(entityName, id);
    }

    @Override
    public List<News> getAll() {
        return provider.getAll(entityName);
    }

    @Override
    public void add(News news) {
        provider.add(entityName, news);
    }

    @Override
    public void update(int id, News news) {
        provider.update(entityName, id, news);
    }

    @Override
    public void delete(int id) {
        provider.delete(entityName, id);
    }
}
