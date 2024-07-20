package model.board;

import services.typeUpgradesInterface;

/**
 * Esta clase representa un tipo de propiedad en el juego.
 *
 * Un tipo de propiedad tiene un nombre asociado.
 * Se utiliza para identificar diferentes tipos de propiedades en el juego.
 * Implementa la interfaz typeUpgradesInterface para proporcionar funcionalidad común a todos los tipos de mejoras.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */
public enum TypeProperty implements typeUpgradesInterface{

    ESCRITURA("Escritura"),
    FERROCARRIL("Ferrocarril"),
    COMPAÑIA("Compañía");

    private final String typeProperty;

    TypeProperty(String typeProperty) {
        this.typeProperty = typeProperty;
    }

    @Override
    public String getTypeUpgrade() {
        return typeProperty;
    }

    @Override
    public Object viewStateProperty(){
        return null;
    }

    @Override
    public Object showUpgradeType(){
        return null;
    }

    public Integer consultValueProperty(Property property) {
        return property.getValue();
    }

    @Override
    public String toString(){
        return typeProperty;
    }
}
