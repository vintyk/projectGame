package by.ecp.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 12.06.2017.
 */
@Embeddable
@NoArgsConstructor
@ToString
@AllArgsConstructor
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
