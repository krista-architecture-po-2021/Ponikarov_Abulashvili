package decorator;

import newsController.INewsController;
import newsController.News;
import newsdto.NewsListDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActualNewsDecorator extends NewsDecorator {
    private Date actualDate;

    public ActualNewsDecorator(INewsController newsController, Date date) {
        super(newsController);

        actualDate = date;
    }

    @Override
    public NewsListDTO getNewsListDTO() {
        List<News> actualNews = new ArrayList<>();

        for (News news: super.getNewsListDTO().getNewsList()) {
            if (news.getDate().after(actualDate)) {
                actualNews.add(news);
            }
        }

        return new NewsListDTO(actualNews);
    }

    @Override
    public News getNewsById(long id) {
        News news = super.getNewsById(id);

        return news.getDate().after(actualDate) ? news : null;
    }
}
