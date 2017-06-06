package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

/**
 * Created by User on 24.05.2017.
 */
//Например, постапокалипcис, фантастика, фэнтези, наши дни, спорт.
  @Entity
  @Table(name = "settings")
  @NoArgsConstructor
  @ToString
public class Setting extends IdMotherClass{
    @Getter
    @Setter
    @Column(name = "name")
    private String name;

}
