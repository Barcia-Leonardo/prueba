package services;

/**
 * Esta interfaz define el contrato para los tipos de mejoras en el juego.
 *
 * Los tipos de mejoras deben ser capaces de proporcionar su nombre, visualizar el estado de la propiedad y mostrar el tipo de mejora.
 *
 * Implementar esta interfaz permite a las clases que representan tipos de mejoras en el juego cumplir con estas funciones.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */

public interface typeUpgradesInterface {

    /**
     * Obtiene el nombre del tipo de mejora.
     *
     * @return El nombre del tipo de mejora.
     */
    String getTypeUpgrade();

    /**
     * Visualiza el estado de la propiedad asociada con el tipo de mejora.
     *
     * @return El estado de la propiedad asociada con el tipo de mejora.
     */
    Object viewStateProperty();

    /**
     * Muestra el tipo de mejora.
     *
     * @return El tipo de mejora.
     */
    Object showUpgradeType();
}
