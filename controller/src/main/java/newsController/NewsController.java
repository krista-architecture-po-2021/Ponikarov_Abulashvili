package newsController;

import model.ModelFactory;
import newsdto.NewsAuthorDTO;
import newsdto.NewsDescriptionDTO;
import newsdto.NewsListDTO;
import newsdto.SportNewsTitleDTO;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class NewsController implements INewsController {
    @Inject
    ModelFactory model;

    @Override
    public NewsListDTO getNewsList() {
        return null;
    }

    @Override
    public News getNewsById(long id) {
        return null;
    }

    @Override
    public void addNews(News addNews) {

    }

    @Override
    public void refreshNews(long id, String newName) {

    }

    @Override
    public void deleteNews(long id) {

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
