package dataobject;

import java.util.Date;

public class News implements IEntity {
    public String type = this.getClass().getSimpleName();
    private Integer id;
    private String name;
    private Date date;
    private String author;
    private String content;
    private int categoryId;

    public News() {

    }

    public News(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(IEntity entity) {
        this.setName(entity.getName());

        if (entity instanceof News) {
            this.setContent(((News) entity).getContent());
            this.setAuthor(((News) entity).getAuthor());
            this.setCategoryId(((News) entity).getCategoryId());
            this.setDate(((News) entity).getDate());
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
