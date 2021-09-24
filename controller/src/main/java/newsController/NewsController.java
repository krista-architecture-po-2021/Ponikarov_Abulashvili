package newsController;

import categoryController.NewsCategory;

import java.util.ArrayList;
import java.util.List;

public class NewsController implements INewsController {
    public List<News> news = new ArrayList<>();

    @Override
    public List<News> getNewsList() {
        return news;
    }

    @Override
    public News getNewsById(Integer id) {
        for (News curNews: news){
            if (curNews.getId().equals(id)){
                return curNews;
            }
        }

        return null;
    }

    @Override
    public void addNews(News addNews) {
        news.add(addNews);
    }

    @Override
    public void refreshNews(Integer id, String newName) {
        for (News curNews: news) {
            if (curNews.getId().equals(id)) {
                curNews.setName(newName);
            }
        }
    }

    @Override
    public void deleteNews(Integer id) {
        news.removeIf(news1 -> news1.getId().equals(id));
    }
}
