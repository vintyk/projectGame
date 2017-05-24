package entity;

/**
 * Created by User on 24.05.2017.
 */
public class Platforms {
    long id;
    String name;

    public Platforms(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
