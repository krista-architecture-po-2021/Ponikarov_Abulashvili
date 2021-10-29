package decorator;

import newsController.INewsController;
import newsController.News;
import newsdto.NewsListDTO;

public abstract class NewsDecorator implements INewsController {
    protected INewsController newsController;

    public NewsDecorator(INewsController newsController){
        this.newsController = newsController;
    }

    @Override
    public NewsListDTO getNewsListDTO() {
        return newsController.getNewsListDTO();
    }

    @Override
    public News getNewsById(long id) {
        return newsController.getNewsById(id);
    }

    @Override
    public void addNews(News news) {
        newsController.addNews(news);
    }

    @Override
    public void updateNews(long id, String newName) {
        newsController.updateNews(id, newName);
    }

    @Override
    public void deleteNews(long id) {
        newsController.deleteNews(id);
    }
}
