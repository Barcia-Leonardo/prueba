package model.board;


import model.support.Zone;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Esta clase representa una propiedad en el juego.
 *
 * Una propiedad tiene un nombre, un valor, un valor de alquiler y una descripción.
 * Implementa la interfaz propertyInterface para proporcionar funcionalidad común a todas las propiedades.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */
public class Property implements Serializable {

    private Integer value;

    private Integer rentValue;

    private String description;

    private TypeProperty typeProperty;

    private TypeUpgradePropertyEnum typeUpgradeProperty;

    private Provinces province;

    private Zone zone;

    private boolean isOwned;

    public Property(Provinces province, Zone zone, Integer value, Integer rentValue, TypeProperty typeProperty, TypeUpgradePropertyEnum typeUpgradeProperty) {
        this.province = province;
        this.zone = zone;
        this.value = value;
        this.rentValue = rentValue;
        this.typeProperty = typeProperty;
        this.typeUpgradeProperty = typeUpgradeProperty;
        this.isOwned = false;
        this.description = "Propiedad en " + province.getNameProvinces() + ", Zona " + zone.name();
    }

    public Property(){

    }

    public Property(String testProperty, Provinces provinces, BigDecimal bigDecimal) {
        this.description = testProperty;
        this.province = provinces;
        this.value = bigDecimal.intValue();
        // Inicializa otros campos según sea necesario
        this.rentValue = 0; // o cualquier valor por defecto que desees
        this.typeProperty = TypeProperty.ESCRITURA; // o cualquier valor por defecto que desees
        this.typeUpgradeProperty = TypeUpgradePropertyEnum.VACIA; // o cualquier valor por defecto que desees
        this.zone = Zone.SUR; // o cualquier valor por defecto que desees
        this.isOwned = false;
    }

    public Property(String testProperty, Provinces provinces, BigDecimal bigDecimal, TypeProperty typeProperty) {
        this.description = testProperty;
        this.province = provinces;
        this.value = bigDecimal.intValue();
        this.typeProperty = typeProperty;
        // Inicializa otros campos según sea necesario
        this.rentValue = 0; // o cualquier valor por defecto que desees
        this.typeUpgradeProperty = TypeUpgradePropertyEnum.VACIA; // o cualquier valor por defecto que desees
        this.zone = Zone.SUR; // o cualquier valor por defecto que desees
        this.isOwned = false;
    }
    public Integer getValue() {
        return value;
    }

    public Integer getRentValue() {
        return rentValue;
    }

    public TypeProperty getTypeProperty() {
        return typeProperty;
    }

    public TypeUpgradePropertyEnum getTypeUpgradeProperty() {
        return typeUpgradeProperty;
    }

    public Provinces getProvince() {
        return province;
    }

    public Zone getZone() {
        return zone;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setOwned(boolean owned) {
        isOwned = owned;
    }

    public String viewProperty() {
        return "Property: " + province + " " + zone + " | Value: " + value + " | Rent: " + rentValue + " | Description: " + description +
                " | Type Property: " + typeProperty.toString() + " | Mejora: " + typeUpgradeProperty;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void upgradeProperty(TypeUpgradePropertyEnum upgradeProperty) {
        this.typeUpgradeProperty = upgradeProperty;
    }

    public void setRentValue(Integer rentValue) {
        this.rentValue = rentValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return province == property.province && zone.equals(property.zone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(province, zone);
    }

}