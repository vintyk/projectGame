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
@Table(name = "vacancies")
@NoArgsConstructor
@ToString
public class Vacancy {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column(name = "name")
    private String nameVacancy;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "companies_id", nullable = false)
    private Company company;
}
