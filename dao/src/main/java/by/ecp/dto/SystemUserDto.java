package by.ecp.dto;

import by.ecp.entity.Address;
import by.ecp.entity.BaseEntity;
import by.ecp.entity.Gender;
import by.ecp.entity.Privilege;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 05.07.2017.
 */
@Data
@NoArgsConstructor
@ToString
public class SystemUserDto {

    public SystemUserDto(
                String nameUser,
                String familyUser,
                String email,
                String passwordUser,
                Long privilegeId,
                Gender gender,
                Address firstAddress,
                Address secondAddress) {
            this.nameUser = nameUser;
            this.familyUser = familyUser;
            this.email = email;
            this.passwordUser = passwordUser;
            this.privilegeId = privilegeId;
            this.gender = gender;
            this.firstAddress = firstAddress;
            this.secondAddress = secondAddress;
        }

        @Getter
        @Setter
        private String nameUser;

        @Getter
        @Setter
        private String familyUser;

        @Getter
        @Setter
        private String email;

        @Getter
        @Setter
        private String passwordUser;

        @Getter
        @Setter
        private Long privilegeId;

        @Getter
        @Setter
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
