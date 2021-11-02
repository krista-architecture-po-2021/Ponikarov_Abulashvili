package facade;

import categoryController.CategoryController;
import categoryController.ICategoryController;
import converter.NewsDTOConverter;
import decorator.ActualNewsDecorator;
import decorator.AuthorNewsDecorator;
import decorator.PositiveNewsDecorator;
import dto.CategoryDTO;
import dto.NewsDTO;
import dto.NewsTitleDTO;
import newsController.INewsController;
import newsController.NewsController;

import java.util.Date;
import java.util.List;

public class FacadeController {
    private List<String> badWords;
    private List<String> selectedAuthors;
    private Date publicationDate;
    private ICategoryController categoryController;
    private INewsController newsController;

    public FacadeController(List<String> badWords, List<String> selectedAuthors,
                            Date publicationDate) {
        this.badWords = badWords;
        this.selectedAuthors = selectedAuthors;
        this.publicationDate = publicationDate;
        categoryController = new CategoryController();

        initNewsController();
    }

    public List<CategoryDTO> getCategoryList(){
        return categoryController.getCategoryList();
    }

    public void addCategory(CategoryDTO categoryDTO){
        categoryController.addCategory(categoryDTO);
    }

    public void updateCategory(int id, CategoryDTO categoryDTO){
        categoryController.updateCategory(id, categoryDTO);
    }

    public void deleteCategory(int id){
        categoryController.deleteCategory(id);
    }

    public List<NewsDTO> getNewsList(){
        return newsController.getNewsList();
    }

    public NewsDTO getNewsById(int id){
        return newsController.getNewsById(id);
    }

    public List<NewsTitleDTO> getNewsTitleList() {
        return newsController.getNewsTitleList();
    }

    public void addNews(NewsDTO newsDTO) {
        newsController.addNews(newsDTO);
    }

    public void updateNews(int id, NewsDTO newsDTO){
        newsController.updateNews(id, newsDTO);
    }

    public void deleteNews(int id){
        newsController.deleteNews(id);
    }

    private void initNewsController() {
        newsController = new NewsController();

        if (badWords != null){
            newsController = new PositiveNewsDecorator(newsController, badWords);
        }

        if (selectedAuthors != null){
            newsController = new AuthorNewsDecorator(newsController, selectedAuthors);
        }

        if (publicationDate != null) {
            newsController = new ActualNewsDecorator(newsController, publicationDate);
        }
    }
}
