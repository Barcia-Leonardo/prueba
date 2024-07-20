package entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "Zone")

public class zoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_zone;

    @Column(name = "zone")
    private String zone;
}
