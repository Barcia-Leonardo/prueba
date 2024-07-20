package entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "users")

public class userEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;

    @OneToMany(mappedBy = "user")
    private List<matchEntity> matchEntities;

    @Column
    private String name;

    @Column
    private String email;

//    @Column
//    private String nationality;

    @Column
    private int age;
}
