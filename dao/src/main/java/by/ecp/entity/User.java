package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vinty on 07.04.2017.
 */
    @Entity
    @Table(name = "users")
    @NoArgsConstructor
    @ToString
    public class User {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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


}