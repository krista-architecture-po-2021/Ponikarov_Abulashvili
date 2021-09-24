package newsController;

import java.util.List;

public interface INewsController {
    public List<News> getNewsList();
    public News getNewsById(Integer id);
    public void addNews(News news);
    public void refreshNews(Integer id, String newName);
    public void deleteNews(Integer id);
}
