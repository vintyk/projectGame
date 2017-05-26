package by.ecp.entity;
import lombok.*;
import javax.persistence.*;
/**
 * Created by User on 24.05.2017.
 */
@Entity
@Table(name="countries")
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "name")
    String name;

}
