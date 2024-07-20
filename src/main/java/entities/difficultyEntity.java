package entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "dificulties")

public class difficultyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_dificulty;

    @Column
    private String dificulty;
}
