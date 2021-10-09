import entity.News;
import jsondao.JsonCategoryDao;
import jsondao.JsonNewsDao;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DaoTest {
    @Order(1)
    @Test
    public void createFile() {
        try (FileWriter fileWriter = new FileWriter("news.json")) {
            fileWriter.write("[]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Order(2)
    @Test
    public void testJsonNewsDaoAdd() {
        JsonNewsDao jsonNewsDao = new JsonNewsDao();
        jsonNewsDao.add(new News(1, "Новость 1", "Содержимое"));
        jsonNewsDao.add(new News(2, "Новость 2", "Содержимое"));
        jsonNewsDao.add(new News(3, "Новость 3", "Содержимое"));

        List<News> newsList = jsonNewsDao.getAll();

        assertEquals(3, newsList.size());
    }

    @Order(3)
    @Test
    public void testJsonNewsDaoGetById(){
        JsonNewsDao jsonNewsDao = new JsonNewsDao();

        News news2 = jsonNewsDao.get(2);

        assertEquals( "Новость 2", news2.getName());
    }

    @Order(4)
    @Test
    public void testJsonNewsUpdate(){
        JsonNewsDao jsonNewsDao = new JsonNewsDao();
        jsonNewsDao.update(2, "Новое содержимое");

        assertEquals("Новое содержимое", jsonNewsDao.get(2).getContent());
    }

    @Order(5)
    @Test
    public void testJsonNewsDelete(){
        JsonNewsDao jsonNewsDao = new JsonNewsDao();
        jsonNewsDao.delete(3);

        assertEquals(2, jsonNewsDao.getAll().size());
    }

}
