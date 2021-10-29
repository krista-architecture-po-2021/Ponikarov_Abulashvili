package newsController;

import model.ModelFactory;
import newsdto.NewsAuthorDTO;
import newsdto.NewsListDTO;
import newsdto.SportNewsTitleDTO;

import javax.inject.Inject;

public class NewsController implements INewsController {
    @Inject
    ModelFactory model;

    @Override
    public NewsListDTO getNewsListDTO() {
        model = ModelFactory.getModel(ModelFactory.JSON);

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
    public void updateNews(long id, String newName) {

    }

    @Override
    public void deleteNews(long id) {

    }
}
