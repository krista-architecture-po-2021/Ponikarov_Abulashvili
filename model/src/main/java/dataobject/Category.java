package dataobject;

public class Category implements IEntity {
    public String type = this.getClass().getSimpleName();
    private int id;
    private String name;

    public Category() {

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
    }
}
