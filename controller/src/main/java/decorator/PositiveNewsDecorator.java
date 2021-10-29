package decorator;

import newsController.INewsController;
import newsController.News;
import newsdto.NewsAuthorDTO;
import newsdto.NewsListDTO;
import newsdto.SportNewsTitleDTO;

import java.util.ArrayList;
import java.util.List;

public class PositiveNewsDecorator extends NewsDecorator {
    private String keyWord;

    public PositiveNewsDecorator(INewsController newsController, String keyWord) {
        super(newsController);

        this.keyWord = keyWord;
    }

    @Override
    public NewsListDTO getNewsListDTO() {
        List<News> actualNews = new ArrayList<>();

        for (News news: super.getNewsListDTO().getNewsList()) {
            if (!news.getContent().contains(keyWord)) {
                actualNews.add(news);
            }
        }

        return new NewsListDTO(actualNews);
    }

    @Override
    public News getNewsById(long id) {
        News news = super.getNewsById(id);

        return news.getContent().contains(keyWord) ? null : news;
    }
}
