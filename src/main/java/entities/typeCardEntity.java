package entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "type_cards")

public class typeCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_type_card;

    @Column
    private String type;
}
