package decorator;

import converter.NewsDTOConverter;
import dto.NewsDTO;
import dto.NewsTitleDTO;
import newsController.INewsController;

import java.util.List;

public abstract class NewsDecorator implements INewsController {
    protected INewsController newsController;

    public NewsDecorator(INewsController newsController){
        this.newsController = newsController;
    }

    @Override
    public List<NewsDTO> getNewsList() {
        return newsController.getNewsList();
    }

    @Override
    public NewsDTO getNewsById(int id) {
        return newsController.getNewsById(id);
    }

    @Override
    public List<NewsTitleDTO> getNewsTitleList() {
        return newsController.getNewsTitleList();
    }

    @Override
    public void addNews(NewsDTO newsDTO) {
        newsController.addNews(newsDTO);
    }

    @Override
    public void updateNews(int id, NewsDTO newsDTO) {
        newsController.updateNews(id, newsDTO);
    }

    @Override
    public void deleteNews(int id) {
        newsController.deleteNews(id);
    }
}
