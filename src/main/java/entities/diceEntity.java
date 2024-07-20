package entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "dices")

public class diceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_dice;

    @Column
    private int side;

    @Column
    private int number_dice;
}
