package provider;

import entity.Category;
import entity.News;

import java.util.*;

public class ArrayProvider implements IProvider {
    List<News> newsList;
    List<Category> categoriesList;

    public  ArrayProvider(){
        newsList = new ArrayList<>();
        categoriesList = new ArrayList<>();
    }

    @Override
    public <T> T get(String entityName, int id) {
        if ("news".equals(entityName)){
            return (T) getElementById(newsList, id, entityName);
        }
        else if ("categories".equals(entityName)){
            return (T) getElementById(categoriesList, id, entityName);
        }

        return null;
    }

    @Override
    public <T> List<T> getAll(String entityName) {
        if ("news".equals(entityName)){
            return (List<T>) newsList;
        }
        else if ("categories".equals(entityName)){
            return (List<T>) categoriesList;
        }

        return null;
    }

    @Override
    public <T> void add(String entityName, T entity) {
        if ("news".equals(entityName)){
            newsList.add((News) entity);
        }
        else if ("categories".equals(entityName)){
            categoriesList.add((Category) entity);
        }
    }

    @Override
    public <T> void update(String entityName, int id, T entity) {
        if ("news".equals(entityName)){
            News news = getElementById(newsList, id, entityName);

            if (news != null) {
                news.setName(((News) entity).getName());
                news.setContent(((News) entity).getContent());
            }
        }
        else if ("categories".equals(entityName)){
            Category category = getElementById(categoriesList, id, entityName);

            if (category != null){
                category.setName(((Category)entity).getName());
            }
        }
    }

    @Override
    public void delete(String entityName, int id) {
        if ("news".equals(entityName)){
            newsList.removeIf(news -> Objects.equals(news.getId(), id));
        }
        else if ("categories".equals(entityName)){
            categoriesList.removeIf(category -> Objects.equals(category.getId(), id));
        }
    }

    private <T> T getElementById(List<T> elements, int id, String entityName){
        for (T element: elements){
            if (("news".equals(entityName) && Objects.equals(((News)element).getId(), id)) ||
                ("categories".equals(entityName) && Objects.equals(((Category)element).getId(), id))){
                return element;
            }
        }

        return null;
    }
}
