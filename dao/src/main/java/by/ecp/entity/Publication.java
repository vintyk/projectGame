package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by User on 09.06.2017.
 */
@Entity
@Table(name = "publications")
@NoArgsConstructor
@ToString
public class Publication extends IdMotherClass {
    @Getter
    @Setter
    @Column(name = "name")
    private String namePublication;

    @Getter
    @Setter
    @Column(name = "text")
    private String text;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;
}
