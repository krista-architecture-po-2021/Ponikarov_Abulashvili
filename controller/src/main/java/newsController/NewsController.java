package newsController;

import converter.NewsBOConverter;
import converter.NewsDTOConverter;
import dto.NewsDTO;
import dto.NewsTitleDTO;
import model.ModelFactory;

import java.util.List;

public class NewsController implements INewsController {
    private final ModelFactory dataProvider;
    private final NewsBOConverter boConverter;

    public NewsController() {
        dataProvider = ModelFactory.getModel(ModelFactory.JSON);
        boConverter = new NewsBOConverter(dataProvider);
    }

    @Override
    public List<NewsDTO> getNewsList() {
        return NewsDTOConverter.createNewsDTOList(
                boConverter.createNewsBOList(dataProvider.getNewsDao().getAll()));
    }

    @Override
    public NewsDTO getNewsById(int id) {
        return NewsDTOConverter.createNewsDTO(boConverter.createNewsBO(dataProvider.getNewsDao().get(id)));
    }

    @Override
    public List<NewsTitleDTO> getNewsTitleList() {
        return NewsDTOConverter.createNewsTitleDTOList(
                boConverter.createNewsBOList(dataProvider.getNewsDao().getAll()));
    }

    @Override
    public void addNews(NewsDTO newsDTO) {
        dataProvider.getNewsDao().add(boConverter.createNewsDO(NewsDTOConverter.createNewsBO(newsDTO)));
    }

    @Override
    public void updateNews(int id, NewsDTO newsDTO) {
        dataProvider.getNewsDao().
                update(id, boConverter.createNewsDO(NewsDTOConverter.createNewsBO(newsDTO)));
    }

    @Override
    public void deleteNews(int id) {
        dataProvider.getNewsDao().delete(id);
    }


}
