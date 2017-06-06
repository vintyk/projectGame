package by.ecp.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by User on 05.06.2017.
 */
@Entity
@Table(name = "releases")
@NoArgsConstructor
@ToString
public class Release extends IdMotherClass{

}
