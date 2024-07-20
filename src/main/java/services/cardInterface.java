package services;



import java.util.List;

/**
 * Esta interfaz define el contrato para las cartas en el juego.
 *
 * Las cartas deben ser capaces de proporcionar una descripción y un tipo.
 *
 * Implementar esta interfaz permite a las clases que representan cartas en el juego cumplir con estas funciones.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */
public interface cardInterface {
    /**
     * Obtiene la descripción de la carta.
     *
     * @return La descripción de la carta.
     */
    String getDescription();



}
