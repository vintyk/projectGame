package by.ecp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

/**
 * Created by Vinty on 11.06.2017.
 */
@Entity
@Table(name = "stages")
@NoArgsConstructor
@ToString
public class Stage extends IdMotherClass{
    @Getter
    @Setter
    @Column(name = "name")
    private String name;
}
