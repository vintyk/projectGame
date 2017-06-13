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
 * Created by Vinty on 11.06.2017.
 */
@Entity
@Table(name = "stages")
@NoArgsConstructor
@ToString
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "we_trust_you")
public class Stage extends IdMotherClass{
    @Getter
    @Setter
    @Column(name = "name")
    private String name;
}
