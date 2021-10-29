package newsController;

import newsdto.NewsAuthorDTO;
import newsdto.NewsListDTO;
import newsdto.SportNewsTitleDTO;

public interface INewsController {
    public NewsListDTO getNewsListDTO();
    public News getNewsById(long id);
    public void addNews(News news);
    public void updateNews(long id, String newName);
    public void deleteNews(long id);
}
