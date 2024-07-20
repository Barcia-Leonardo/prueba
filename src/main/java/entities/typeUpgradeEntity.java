package entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "Type_upgrade")

public class typeUpgradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_type_upgrade;

    @Column
    private String type_upgrade;
}
