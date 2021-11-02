package decorator;

import converter.NewsDTOConverter;
import dto.NewsDTO;
import dto.NewsTitleDTO;
import newsController.INewsController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ActualNewsDecorator extends NewsDecorator {
    private Date actualDate;

    public ActualNewsDecorator(INewsController newsController, Date date) {
        super(newsController);

        actualDate = date;
    }

    @Override
    public List<NewsDTO> getNewsList() {
        List<NewsDTO> actualNews = new ArrayList<>();

        for (NewsDTO newsDTO: super.getNewsList()) {
            if (Objects.equals(newsDTO.getDate(), actualDate)) {
                actualNews.add(newsDTO);
            }
        }

        return actualNews;
    }

    @Override
    public List<NewsTitleDTO> getNewsTitleList() {
        return NewsDTOConverter.createNewsTitleDTOList(
                NewsDTOConverter.createNewsBOList(getNewsList()));
    }

    @Override
    public NewsDTO getNewsById(int id) {
        NewsDTO newsDTO = super.getNewsById(id);

        return Objects.equals(newsDTO.getDate(), actualDate) ? newsDTO : null;
    }
}
