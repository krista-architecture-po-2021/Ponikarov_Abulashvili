package decorator;

import newsController.INewsController;
import newsController.News;
import newsdto.NewsListDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AuthorNewsDecorator extends NewsDecorator {
    private String author;

    public AuthorNewsDecorator(INewsController newsController, String author) {
        super(newsController);

        this.author = author;
    }

    @Override
    public NewsListDTO getNewsListDTO() {
        List<News> actualNews = new ArrayList<>();

        for (News news: super.getNewsListDTO().getNewsList()) {
            if (Objects.equals(news.getAuthor(), author)) {
                actualNews.add(news);
            }
        }

        return new NewsListDTO(actualNews);
    }

    @Override
    public News getNewsById(long id) {
        News news = super.getNewsById(id);

        return Objects.equals(news.getAuthor(), author) ? news : null;
    }
}
