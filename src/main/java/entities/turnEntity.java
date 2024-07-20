package entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "Turns")

public class turnEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_turn;

    @Column
    private String shift_turn;
}
