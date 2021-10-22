package dataobject;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({@JsonSubTypes.Type(
        value = News.class,
        name = "News"
),
        @JsonSubTypes.Type(
        value = Category.class,
        name = "Category"
)})
public interface IEntity {
    public int getId();

    public void setId(int id);

    public String getName();

    public void setName(String name);

    public void update(IEntity entity);
}
