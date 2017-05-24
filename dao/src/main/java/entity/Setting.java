package entity;

/**
 * Created by User on 24.05.2017.
 */
//Например, постапокалипчис, фантастика, фэнтези, наши дни, спорт.
public class Setting {
    long id;
    String name;

    public Setting(long id, String name) {
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
