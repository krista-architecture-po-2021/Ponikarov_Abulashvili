package dataobject;

public class News implements IEntity {
    public String type = this.getClass().getSimpleName();
    private int id;
    private String name;
    private String content;

    public News() {

    }

    public News(int id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
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
            this.setContent(((News)entity).getContent());
        }
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
