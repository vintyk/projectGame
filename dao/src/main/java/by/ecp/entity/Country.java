package by.ecp.entity;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

/**
 * Created by SystemUser on 24.05.2017.
 */
@Entity
@Table(name="countries")
@ToString
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "we_trust_you")
public class Country extends BaseEntity {
    @Column(name = "name")
    @Getter
    @Setter
    private String name;
}
