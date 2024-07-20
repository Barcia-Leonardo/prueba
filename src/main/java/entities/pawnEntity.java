package entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "pawns")

public class pawnEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pawn;

    @OneToOne
    @JoinColumn(name = "id_player")
    private playerEntity id_player;

    @OneToMany
    @JoinColumn(name = "id_card")
    private List<pawnEntity> id_card;

    @OneToMany
    @JoinColumn(name = "id_property")
    private List<propertyEntity> propertyEntities;

    @Column
    private double money;

    @Column
    private boolean active;
}
