package by.ecp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by User on 12.06.2017.
 */
@Entity
@ToString(callSuper = true)
@DiscriminatorValue("additional")
public class GameAdditionGoods extends Game{
    @Column(name = "name")
    @Getter
    @Setter
    private String name;
}
