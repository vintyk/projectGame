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
 * Created by SystemUser on 24.05.2017.
 */
//Например, постапокалипcис, фантастика, фэнтези, наши дни, спорт.
  @Entity
  @Table(name = "settings")
  @NoArgsConstructor
  @ToString
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "we_trust_you")
public class Setting extends BaseEntity {
    @Getter
    @Setter
    @Column(name = "name")
    private String name;

}
