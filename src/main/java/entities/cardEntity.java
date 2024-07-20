package entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "cards")

public class cardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_card;

    @OneToOne
    @JoinColumn(name = "id_type_card")
    private typeCardEntity id_type_card;

    @Column
    private String description;
}
