package newsdto;

import newsController.News;

import java.util.List;

public class NewsListDTO {
    List<News> newsList;

    public NewsListDTO(List<News> newsList) {
        this.newsList = newsList;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
