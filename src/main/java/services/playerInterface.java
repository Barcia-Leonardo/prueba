package services;

import model.player.TypePlayer;
import model.support.Turn;

import java.lang.reflect.Type;

/**
 * Esta interfaz define el contrato para los jugadores en el juego.
 *
 * Los jugadores deben ser capaces de proporcionar su nombre, su tipo y el turno actual que les corresponde.
 *
 * Implementar esta interfaz permite a las clases que representan jugadores en el juego cumplir con estas funciones.
 *
 * También se proporciona un ejemplo de método adicional comentado que podría ser parte de la interfaz en futuras iteraciones.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */

public interface playerInterface {

    /**
     * Obtiene el nombre del jugador.
     *
     * @return El nombre del jugador.
     */
    String getplayerName();

    /**
     * Obtiene el tipo de jugador.
     *
     * @return El tipo de jugador.
     */
    TypePlayer getTypePlayer();

    /**
     * Obtiene el turno actual del jugador.
     *
     * @return El turno actual del jugador.
     */
    Integer getTurn();

    /*
        Ejemplo de método adicional que podría ser parte de la interfaz en futuras iteraciones
        GetDices();
    */

}
