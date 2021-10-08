import entity.News;
import jsondao.JsonCategoryDao;
import jsondao.JsonNewsDao;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DaoTest {
    @Test
    public void testJsonNewsDaoAdd(){
        JsonNewsDao jsonNewsDao = createJsonNewsDao();

        List<News> newsList = jsonNewsDao.getAll();

        assertEquals(newsList.size(), 2);

        News news2 = jsonNewsDao.get(2);

        assertEquals(news2.getName(), "Новость 2");
    }

    @Test
    public void testJsonNewsDaoGetById(){
        JsonNewsDao jsonNewsDao = createJsonNewsDao();

        News news2 = jsonNewsDao.get(2);

        assertEquals(news2.getName(), "Новость 2");
    }

    @Test
    public void testJsonNewsDelete(){
        JsonNewsDao jsonNewsDao = createJsonNewsDao();
        jsonNewsDao.delete(2);

        assertEquals(jsonNewsDao.getAll().size(), 1);
    }

    @Test
    public void testJsonNewsUpdate(){
        JsonNewsDao jsonNewsDao = createJsonNewsDao();
        jsonNewsDao.update(2, "Новое содержимое");

        assertEquals(jsonNewsDao.get(2).getContent(), "Новое содержимое");
    }

    private JsonNewsDao createJsonNewsDao(){
        JsonNewsDao jsonNewsDao = new JsonNewsDao();
        jsonNewsDao.add(new News(1, "Новость 1", "Содержимое"));
        jsonNewsDao.add(new News(2, "Новость 2", "Содержимое"));

        return jsonNewsDao;
    }
}
