package services;

import model.board.TypeProperty;
import model.board.TypeUpgradeProperty;

import java.math.BigDecimal;

/**
 * Esta interfaz define el contrato para las propiedades en el juego.
 *
 * Las propiedades deben ser capaces de proporcionar su nombre, valor, valor de alquiler y descripción.
 *
 * Implementar esta interfaz permite a las clases que representan propiedades en el juego cumplir con estas funciones.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */

public interface propertyInterface {

    /**
     * Obtiene el nombre de la propiedad.
     *
     * @return El nombre de la propiedad.
     */
    String getPropertyName();

    /**
     * Obtiene el valor de la propiedad.
     *
     * @return El valor de la propiedad.
     */
    Integer getValue();

    /**
     * Obtiene el valor de alquiler de la propiedad.
     *
     * @return El valor de alquiler de la propiedad.
     */
    Integer getRentValue();

    /**
     * Obtiene la descripción de la propiedad.
     *
     * @return La descripción de la propiedad.
     */
    String getDescription();

    /**
     * Obtiene el tipo de la propiedad.
     *
     * @return el tipo de la propiedad.
     */

    TypeProperty getTypeProperty();
    /**
     * Obtiene el tipo de mejora de la propiedad.
     *
     * @return el tipo de mejora de la propiedad.
     */
    TypeUpgradeProperty getUpgradeProperty();
    /*
    getStateProperty();
    */
}
