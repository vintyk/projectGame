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
public class Country extends IdMotherClass{
    @Column(name = "name")
    @Getter
    @Setter
    private String name;
}
