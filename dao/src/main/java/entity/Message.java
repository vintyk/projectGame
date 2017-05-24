package entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Vinty on 24.05.2017.
 */
@Entity
@Table(name="messages")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Column(name="name")
    @Getter
    @Setter
    private String name;


}
