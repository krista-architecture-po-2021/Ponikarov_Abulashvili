package converter;

import dataobject.Category;
import model.ModelFactory;
import newsController.News;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NewsBOConverter {
    ModelFactory dataProvider;

    public NewsBOConverter(ModelFactory dataProvider) {
        this.dataProvider = dataProvider;
    }

    public News createNewsBO(dataobject.News newsDO) {
        News newsBO = new News();
        newsBO.setId(newsDO.getId());
        newsBO.setName(newsDO.getName());
        newsBO.setAuthor(newsDO.getAuthor());
        newsBO.setContent(newsDO.getContent());
        newsBO.setDate(newsDO.getDate());

        Category category = dataProvider.getCategoriesDao().get(newsDO.getCategoryId());

        if (category != null) {
            newsBO.setCategoryName(dataProvider.getCategoriesDao().get(newsDO.getCategoryId()).getName());
        }
        else {
            newsBO.setCategoryName("Empty");
        }

        return newsBO;
    }

    public dataobject.News createNewsDO(News newsBO) {
        dataobject.News newsDO = new dataobject.News();
        newsDO.setId(newsBO.getId());
        newsDO.setName(newsBO.getName());
        newsDO.setAuthor(newsBO.getAuthor());
        newsDO.setContent(newsBO.getContent());
        newsDO.setDate(newsBO.getDate());

        Category category = dataProvider.getCategoriesDao().get(newsDO.getCategoryId());

        if (category != null) {
            newsDO.setCategoryId(getCategoryId(category.getName()));
        }
        else {
            newsDO.setCategoryId(0);
        }


        return newsDO;
    }

    public List<News> createNewsBOList(List<dataobject.News> newsDOList) {
        return newsDOList.stream().map(this::createNewsBO).collect(Collectors.toList());
    }

    private int getCategoryId(String categoryName) {
        for (dataobject.Category category: dataProvider.getCategoriesDao().getAll()) {
            if (Objects.equals(category.getName(), categoryName)) {
                return category.getId();
            }
        }

        return 0;
    }
}
