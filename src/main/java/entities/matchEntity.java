package entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "matches")
public class matchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_match;

    @ManyToOne
    @JoinColumn(name = "id_board")
    private boardEntity board;

    @ManyToMany
    @JoinTable(
            name = "match_player",
            joinColumns = @JoinColumn(name = "id_match"),
            inverseJoinColumns = @JoinColumn(name = "id_player")
    )
    private List<playerEntity> players;

    @OneToOne
    @JoinColumn(name = "id_difficulty")
    private difficultyEntity difficulty;

    @OneToOne
    @JoinColumn(name = "id_bank")
    private bankEntity bank;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private userEntity user;
}