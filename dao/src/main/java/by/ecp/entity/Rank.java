package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by User on 24.05.2017.
 */
@Entity
@Table(name = "ranks")
@NoArgsConstructor
@ToString
public class Rank extends IdMotherClass{
    @Column(name = "name")
    @Getter
    @Setter
    private String name;

}
