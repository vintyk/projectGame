package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Vinty on 09.04.2017.
 */
@Entity
@Table(name="genres")
@ToString
@NoArgsConstructor
public class Genre extends IdMotherClass{
    @Column(name = "name")
    @Getter
    @Setter
    private String name;


}
