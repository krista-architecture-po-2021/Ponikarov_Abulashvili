
import categoryController.NewsCategory;
import facade.NewsService;

import newsController.News;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestClass {
    @Test
    public void getCategoryListTest(){
        NewsService newsService = new NewsService();

        List<NewsCategory> category = newsService.getCategoryList();

        assertNotNull(category);
    }

    @Test
    public void addCategoryTest(){
        NewsService newsService = new NewsService();
        newsService.addCategory(new NewsCategory(1, "Category1"));
        newsService.addCategory(new NewsCategory(2, "Category2"));

        assertEquals(2, newsService.getCategoryList().size());
    }

    @Test
    public void refreshCategoryTest(){
        NewsService newsService = new NewsService();
        newsService.refreshCategory(2, "Category3");

        NewsCategory searchCategory = null;

        for (NewsCategory category: newsService.getCategoryList()){
            if (category.getName().equals("Category3")){
                searchCategory = category;
            }
        }

        assertNotNull(searchCategory);
    }

    @Test
    public void deleteCategoryTest(){
        NewsService newsService = new NewsService();
        newsService.deleteCategory(2);

        assertEquals(1, newsService.getCategoryList().size());
    }

    @Test
    public void getNewsListTest(){
        NewsService newsService = new NewsService();

        List<News> news = newsService.getNewsList();
        newsService.addNews(new News(1, "News1"));

        assertEquals(1, news.size());
    }

    @Test
    public void getNewsByIdTest(){
        NewsService newsService = new NewsService();
        newsService.addNews(new News(1, "News1"));

        News news = newsService.getNewsById(1);

        assertEquals("News1", news.getName());
    }

    @Test
    public void addNewsTest(){
        NewsService newsService = new NewsService();
        newsService.addNews(new News(1, "News1"));

        assertEquals(1, newsService.getNewsList().size());
    }

    @Test
    public void refreshNewsTest(){
        NewsService newsService = new NewsService();
        newsService.addNews(new News(1, "News1"));
        newsService.addNews(new News(2, "News2"));
        newsService.refreshNews(2, "Category3");

        News searchNews = null;

        for (News curNews: newsService.getNewsList()){
            if (curNews.getName().equals("Category3")){
                searchNews = curNews;
            }
        }

        assertNotNull(searchNews);
    }

    @Test
    public void deleteNewsTest(){
        NewsService newsService = new NewsService();
        newsService.addNews(new News(1, "News1"));
        newsService.addNews(new News(2, "News2"));
        newsService.deleteNews(1);

        assertEquals(1, newsService.getNewsList().size());
    }
}
