package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Vinty on 07.04.2017.
 */
    @Entity
    @Table(name = "users")
    @NoArgsConstructor
    @ToString
    public class User extends BaseEntity {
    @Getter
    @Setter
    @Column(name = "name")
    private String nameUser;

    @Getter
    @Setter
    @Column(name = "family")
    private String familyUser;

    @Getter
    @Setter
    @Column(name = "e_mail")
    private String eMailUser;

    @Getter
    @Setter
    @Column(name = "password")
    private String passwordUser;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "privilege_id", nullable = false)
    private Privilege privilege;

    @Getter
    @Setter
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Getter
    @Setter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "home_region_country")),
            @AttributeOverride(name = "city", column = @Column(name = "home_region_City"))
    })
    private Address firstAddress;

    @Getter
    @Setter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "payment_country")),
            @AttributeOverride(name = "city", column = @Column(name = "payment_city"))
    })
    private Address secondAddress;

}