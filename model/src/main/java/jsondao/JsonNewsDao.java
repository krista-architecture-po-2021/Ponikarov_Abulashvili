package jsondao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Dao;
import entity.News;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class JsonNewsDao implements Dao<News> {
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
            return objectMapper.readValue(new File(filePath), new TypeReference<List<News>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void writeNews(List<News> news){
        try (FileWriter fileWriter = new FileWriter("news.json", false)){
            fileWriter.write(objectMapper.writeValueAsString(news));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
