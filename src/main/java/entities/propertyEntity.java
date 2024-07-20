package entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@NoArgsConstructor
@Entity
@Table(name = "properties")
public class propertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_property;

    @OneToOne
    @JoinColumn(name = "type_properties")
    private typePropertyEntity id_type_property;

    @OneToOne
    @JoinColumn(name = "id_zone")
    private zoneEntity id_zone;

    @OneToOne
    @JoinColumn(name = "id_type_upgrade")
    private typeUpgradeEntity id_type_upgrade;

    @OneToOne
    @JoinColumn(name = "id_province")
    private provinceEntity id_province;

    @Column
    private double property_value;

    @Column
    private double rent_value;

    @Column(length = 255)
    private String description;
}