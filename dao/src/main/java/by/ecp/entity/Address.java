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
    @Column(name = "current_county")
    @Getter
    @Setter
    private String country;
    @Column(name = "current_city")
    @Getter
    @Setter
    private String city;

}
