package dataobject;

public interface IEntity {
    public int getId();

    public void setId(int id);

    public String getName();

    public void setName(String name);

    public void update(IEntity entity);
}
