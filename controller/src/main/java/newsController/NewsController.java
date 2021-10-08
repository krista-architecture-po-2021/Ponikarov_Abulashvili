package newsController;

import model.IModel;
import newsdto.NewsAuthorDTO;
import newsdto.NewsDescriptionDTO;
import newsdto.NewsListDTO;
import newsdto.SportNewsTitleDTO;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class NewsController implements INewsController {
    @Inject
    IModel model;

    @Override
    public NewsListDTO getNewsList() {
        return model.getNewsDao().getAll();
    }

    @Override
    public News getNewsById(long id) {
        return model.getNewsDao().get(id);
    }

    @Override
    public void addNews(News addNews) {
        model.getNewsDao().add();
    }

    @Override
    public void refreshNews(long id, String newName) {
        for (News curNews: news) {
            if (curNews.getId().equals(id)) {
                curNews.setName(newName);
            }
        }
    }

    @Override
    public void deleteNews(long id) {
        news.removeIf(news1 -> news1.getId().equals(id));
    }

    @Override
    public NewsDescriptionDTO getNewsDescription(News news) {
        return null;
    }

    @Override
    public NewsAuthorDTO getNewsAuthor(News news) {
        return null;
    }

    @Override
    public SportNewsTitleDTO getSportNewsTitle(News news) {
        return null;
    }
}
