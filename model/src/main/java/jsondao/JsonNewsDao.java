package jsondao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.INewsDao;
import entity.News;
import entity.NewsCategory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class JsonNewsDao implements INewsDao {
    ObjectMapper objectMapper;

    private static final String filePath = "news.json";

    public JsonNewsDao() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public News get(int id) {
        List<News> newsList = readNews();

        if (newsList != null) {
            for (News curNews : newsList) {
                if (Objects.equals(curNews.getId(), id)) {
                    return curNews;
                }
            }
        }

        return null;
    }

    @Override
    public List<News> getAll() {
        return readNews();
    }

    @Override
    public void add(News news) {
        List<News> newsList = readNews();

        if (newsList != null){
            newsList.add(news);

            writeNews(newsList);
        }
    }

    @Override
    public void update(int id, String content) {
        List<News> newsList = readNews();

        if (newsList != null){
            for (News curNews: newsList){
                if (Objects.equals(curNews.getId(), id)) {
                    curNews.setContent(content);
                }
            }

            writeNews(newsList);
        }
    }

    @Override
    public void delete(int id) {
        List<News> newsList = readNews();

        if (newsList != null) {
            newsList.removeIf(news -> Objects.equals(news.getId(), id));

            writeNews(newsList);
        }
    }

    private List<News> readNews(){
        try {
            return objectMapper.readValue(filePath, new TypeReference<List<News>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void writeNews(List<News> news){
        try {
            objectMapper.writeValue(new File(filePath), news);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}