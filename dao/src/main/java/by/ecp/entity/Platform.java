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
@Table(name="platforms")
@ToString
@NoArgsConstructor
public class Platform {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Setter
    @Getter
    @Column(name = "name")
    String name;

}
