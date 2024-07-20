package entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "players")

public class playerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_player;

    @OneToOne
    @JoinColumn(name = "id_type_player")
    private typePlayerEntity id_type_player;

    @OneToOne
    @JoinColumn(name = "id_turn")
    private turnEntity id_turn;
}
