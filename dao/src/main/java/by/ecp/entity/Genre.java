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
 * Created by Vinty on 09.04.2017.
 */
@Entity
@Table(name="genres")
@ToString
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Long_happy_life")
public class Genre extends BaseEntity {
    @Column(name = "name")
    @Getter
    @Setter
    private String name;
}
