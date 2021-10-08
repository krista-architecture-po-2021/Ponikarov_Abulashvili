package arraydao;

import dao.INewsDao;
import entity.News;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ArrayNewsDao implements INewsDao {
    List<News> newsList;

    public ArrayNewsDao() {
        newsList = new ArrayList<>(Arrays.asList(new News(1, "Новость 1", "Содержимое"),
                new News(2, "Новость 2", "Содержимое"),
                new News(3, "Новость 3", "Содержимое"),
                new News(4, "Новость 4", "Содержимое")));

    }

    @Override
    public News get(int id) {
        for (News news: newsList){
            if (Objects.equals(news.getId(), id)){
                return news;
            }
        }

        return null;
    }

    @Override
    public List<News> getAll() {
        return newsList;
    }

    @Override
    public void add(News news) {
        newsList.add(news);
    }

    @Override
    public void update(int id, String content) {
        for (News news: newsList){
            if (Objects.equals(news.getId(), id)){
                news.setContent(content);
            }
        }
    }

    @Override
    public void delete(int id) {
        newsList.removeIf(news1 -> Objects.equals(news1.getId(), id));
    }
}
