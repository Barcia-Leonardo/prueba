package entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "type_boxes")

public class typeBoxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_type_box;

    @Column
    private String type;
}
