package entities;

import lombok.NoArgsConstructor;
import model.board.Property;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;



@NoArgsConstructor
@Entity
@Table(name = "banks")

public class bankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_bank;

    @OneToMany
    @JoinColumn(name="id_property")
    private List<propertyEntity> propertyList;

    @Column
    private double money;

//    public double getMoney() {
//        return money;
//    }
//
//    public void setMoney(double money) {
//        this.money = money;
//    }
//
//    public List<propertyEntity> getProperties() {
//        return propertyList;
//    }
//
//    public void setProperties(List<propertyEntity> properties) {
//        this.propertyList = properties;
//    }
}
