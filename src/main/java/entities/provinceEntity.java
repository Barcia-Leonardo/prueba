package entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "Provinces")

public class provinceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_province;

    @Column
    private String province_name;
}
