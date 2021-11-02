package decorator;

import converter.NewsDTOConverter;
import dto.NewsDTO;
import dto.NewsTitleDTO;
import newsController.INewsController;

import java.util.ArrayList;
import java.util.List;

public class PositiveNewsDecorator extends NewsDecorator {
    private List<String> badWords;

    public PositiveNewsDecorator(INewsController newsController, List<String> badWords) {
        super(newsController);

        this.badWords = badWords;
    }

    @Override
    public List<NewsDTO> getNewsList() {
        List<NewsDTO> actualNews = new ArrayList<>();

        for (NewsDTO newsDTO: super.getNewsList()) {
            if (!newsContainBadWords(newsDTO, badWords)) {
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

        return newsContainBadWords(newsDTO, badWords) ? null : newsDTO;
    }

    private boolean newsContainBadWords(NewsDTO newsDTO, List<String> badWords) {
        for (String badWord: badWords) {
            if (newsDTO.getContent().contains(badWord)) {
                return true;
            }
        }

        return false;
    }
}
