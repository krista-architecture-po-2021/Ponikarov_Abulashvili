package newsController;

import newsdto.NewsAuthorDTO;
import newsdto.NewsDescriptionDTO;
import newsdto.NewsListDTO;
import newsdto.SportNewsTitleDTO;

import java.util.List;

public interface INewsController {
    public NewsListDTO getNewsList();
    public News getNewsById(long id);
    public void addNews(News news);
    public void refreshNews(long id, String newName);
    public void deleteNews(long id);
    public NewsDescriptionDTO getNewsDescription(News news);
    public NewsAuthorDTO getNewsAuthor(News news);
    public SportNewsTitleDTO getSportNewsTitle(News news);
}
