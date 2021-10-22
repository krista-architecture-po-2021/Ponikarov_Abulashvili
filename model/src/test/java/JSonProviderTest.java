import dataobject.News;
import org.junit.Test;
import provider.JsonProvider;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class JSonProviderTest {
    @Test
    public void createFile() {
        try (FileWriter fileWriter = new FileWriter("news.json")) {
            fileWriter.write("[]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addNewsTest() {
        JsonProvider jSonProvider = new JsonProvider();
        jSonProvider.add("news", new News(1, "Новость 1", "Содержимое 1"));
        jSonProvider.add("news", new News(2, "Новость 2", "Содержимое 2"));
        jSonProvider.add("news", new News(3, "Новость 3", "Содержимое 3"));
//
//        List<News> newsList = jSonProvider.getAll("news");
//
//        assertEquals(3, newsList.size());
    }

    @Test
    public void getNewsByIdTest() {
        JsonProvider jSonProvider = new JsonProvider();
        IEntity entity = jSonProvider.get("news", 2);


        assertEquals("Новость 2", entity.getName());
    }
}
