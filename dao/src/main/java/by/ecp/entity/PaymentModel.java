package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by User on 24.05.2017.
 */
@Entity
@Table(name= "payment_models")
@ToString
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "we_trust_you")
@Repository
public class PaymentModel extends IdMotherClass{
    @Column(name = "name")
    @Getter
    @Setter
    private String name;

}
