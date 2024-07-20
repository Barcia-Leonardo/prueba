package entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "boards")
public class boardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_board;

    @OneToMany
    private List<matchEntity> matches;

    @OneToMany
    private List<boxEntity> boxes;

    @OneToMany
    private List<cardEntity> cards;

    @OneToMany
    private List<diceEntity> dice;
}
