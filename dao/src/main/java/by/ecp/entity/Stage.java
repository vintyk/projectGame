package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by User on 24.05.2017.
 */
//Например, отменена, в разработке, ранний доступ, запущена.
    @Entity
    @NoArgsConstructor
    @Table(name = "stages")
    @ToString
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Column(name = "name")
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    @Column(name = "date_stage")
    private LocalDate date;


}
