package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by SystemUser on 21.04.2017.
 */
@Entity
@Table(name = "privileges")
@ToString
@NoArgsConstructor
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "we_trust_you")
public class Privilege extends BaseEntity {
    @Setter
    @Getter
    @Column(name = "name")
    private String namePrivilege;
}
