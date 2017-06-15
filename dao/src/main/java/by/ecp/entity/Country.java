package by.ecp.entity;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by User on 24.05.2017.
 */
@Entity
@Table(name="countries")
@ToString
@NoArgsConstructor
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "we_trust_you")
public class Country extends IdMotherClass{
    @Column(name = "name")
    @Getter
    @Setter
    private String name;
}
