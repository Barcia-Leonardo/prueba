package entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "boxes")

public class boxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_box;

    @OneToMany
    @JoinColumn(name = "id_pawns")
//    private ArrayList<pawnEntity> pawnEntities;
    private List<pawnEntity> pawns;

    @OneToOne
    @JoinColumn(name = "id_type_box")
    private typeBoxEntity id_type_box;

    @OneToOne
    @JoinColumn(name = "id_property")
    private propertyEntity id_property;
}
