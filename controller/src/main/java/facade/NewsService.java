package facade;

import categoryController.CategoryController;
import categoryController.ICategoryController;
import categoryController.Category;
import newsController.INewsController;
import newsController.News;
import newsController.NewsController;

import java.util.List;

public class NewsService {
    private final ICategoryController categoryController = new CategoryController();

    private final INewsController newsController = new NewsController();


    public List<Category> getCategoryList(){
        return categoryController.getCategoryList();
    }

    public void addCategory(Category category){
        categoryController.addCategory(category);
    }

    public void refreshCategory(Integer id, String newName){
        categoryController.refreshCategory(id, newName);
    }

    public void deleteCategory(Integer id){
        categoryController.deleteCategory(id);
    }

    public List<News> getNewsList(){
        return null;
    }

    public News getNewsById(Integer id){
        return newsController.getNewsById(id);
    }

    public void addNews(News news) {
        newsController.addNews(news);
    }

    public void refreshNews(Integer id, String newName){
        newsController.updateNews(id, newName);
    }

    public void deleteNews(Integer id){
        newsController.deleteNews(id);
    }

    private void initNewsController() {

    }
}
