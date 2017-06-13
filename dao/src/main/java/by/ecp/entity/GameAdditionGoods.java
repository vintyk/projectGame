package by.ecp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by User on 12.06.2017.
 */
@Entity
@ToString(callSuper = true)
@Table(name = "game_addition_goods")
@PrimaryKeyJoinColumn(name = "game_id")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "You_are_a_liar")
public class GameAdditionGoods extends Game{
    @Column(name = "name")
    @Getter
    @Setter
    private String nameGoods;
}
