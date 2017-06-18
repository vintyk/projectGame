package by.ecp.entity;

import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

/**
 * Created by User on 12.06.2017.
 */
@Embeddable
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Long_happy_life")
@Repository
public class Address {
    @Column(name = "country")
    @Getter
    @Setter
    private String country;
    @Column(name = "city")
    @Getter
    @Setter
    private String city;

}
