package newsController;

import converter.NewsDTOConverter;
import dto.NewsDTO;
import dto.NewsTitleDTO;

import java.util.List;

public interface INewsController {
    public List<NewsDTO> getNewsList();
    public NewsDTO getNewsById(int id);
    public List<NewsTitleDTO> getNewsTitleList();
    public void addNews(NewsDTO newsDTO);
    public void updateNews(int id, NewsDTO newsDTO);
    public void deleteNews(int id);
}
