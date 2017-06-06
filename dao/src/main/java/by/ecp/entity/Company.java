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
@Table(name = "companies")
@ToString
@NoArgsConstructor
public class Company extends IdMotherClass{
    @Setter
    @Getter
    @Column(name = "name")
    private String nameCompany;
}
