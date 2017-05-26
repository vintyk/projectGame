package by.ecp;

/**
 * Created by User on 25.05.2017.
 */
import lombok.*;
import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name="message")
@ToString
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;
}
