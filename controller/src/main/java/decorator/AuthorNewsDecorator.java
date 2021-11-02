package decorator;

import converter.NewsDTOConverter;
import dto.NewsDTO;
import dto.NewsTitleDTO;
import newsController.INewsController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AuthorNewsDecorator extends NewsDecorator {
    private List<String> selectedAuthors;

    public AuthorNewsDecorator(INewsController newsController, List<String> selectedAuthors) {
        super(newsController);
        this.selectedAuthors = selectedAuthors;
    }

    @Override
    public List<NewsDTO> getNewsList() {
        List<NewsDTO> actualNews = new ArrayList<>();

        for (NewsDTO newsDTO: super.getNewsList()) {
            if (newsWroteSelectedAuthors(newsDTO, selectedAuthors)) {
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

        return newsWroteSelectedAuthors(newsDTO, selectedAuthors) ? newsDTO : null;
    }

    private boolean newsWroteSelectedAuthors(NewsDTO newsDTO, List<String> selectedAuthors) {
        for (String author: selectedAuthors) {
            if (!newsDTO.getAuthor().contains(author)) {
                return false;
            }
        }

        return true;
    }
}
