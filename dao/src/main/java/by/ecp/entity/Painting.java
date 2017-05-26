package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Vinty on 26.05.2017.
 */
@Entity
@Table(name="paintings")
@ToString
@NoArgsConstructor
public class Painting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "author_name")
    @Getter
    @Setter
    private String authorName;

}
