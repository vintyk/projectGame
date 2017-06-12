package by.ecp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by User on 12.06.2017.
 */
@Entity
@ToString(callSuper = true)
@Table(name = "game_addition_goods")
@PrimaryKeyJoinColumn(name = "game_id")
public class GameAdditionGoods extends Game{
    @Column(name = "name")
    @Getter
    @Setter
    private String nameGoods;
}
