package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;

/**
 * Created by User on 02.06.2017.
 */
@Entity
@Table(name = "vacancies")
@NoArgsConstructor
@ToString
@Service
public class Vacancy extends IdMotherClass{
    @Getter
    @Setter
    @Column(name = "name")
    private String nameVacancy;
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "companies_id", nullable = false)
    private Company company;

    @Autowired
    public Vacancy(Company nameCompany){
        this.nameVacancy = nameVacancy;
        this.company = nameCompany;
    }
}
