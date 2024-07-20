package entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "type_properties")

public class typePropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_type_property;

    @Column
    private String type_property;

}
