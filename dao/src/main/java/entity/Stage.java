package entity;

import java.time.LocalDate;

/**
 * Created by User on 24.05.2017.
 */
//Например, отменена, в разработке, ранний доступ, запущена.
public class Stage {
    long id;
    String name;
    LocalDate date;

    public Stage(long id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
