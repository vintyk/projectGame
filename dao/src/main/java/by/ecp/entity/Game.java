package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by User on 02.06.2017.
 */
@Entity
@Table(name = "games")
@NoArgsConstructor
@ToString
public class Game {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "name")
    private String nameGame;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "payment_model_id", nullable = false)
    private PaymentModel paymentModel;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "setting_id", nullable = false)
    private Setting setting;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "stage_id", nullable = false)
    private Stage stage;

}
