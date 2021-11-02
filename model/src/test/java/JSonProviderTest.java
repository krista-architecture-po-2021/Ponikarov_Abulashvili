import dataobject.Category;
import dataobject.IEntity;
import dataobject.News;
import org.junit.Test;
import provider.JsonProvider;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JSonProviderTest {
    @Test
    public void writeNewsToJsonTest() {
        News news = new News();
        news.setId(1);
        news.setName("News1");
        news.setContent("Empty");
        news.setAuthor("Author");
        news.setDate(new Date(2021, Calendar.NOVEMBER, 5));
        news.setCategoryId(10);

        JsonProvider jsonProvider = new JsonProvider();
        jsonProvider.add("news", news);
    }

    @Test
    public void writeCategoryToJsonTest() {
        Category category = new Category();
        category.setId(1);
        category.setName("CategoryName");

        JsonProvider jsonProvider = new JsonProvider();
        jsonProvider.add("categories", category);
    }
}
