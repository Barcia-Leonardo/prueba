package model;

import model.support.Turn;

/**
 * Esta clase representa un usuario en el juego.
 *
 * Un usuario tiene un nombre asociado.
 * Implementa métodos para obtener el tipo de jugador y el turno asociado con el usuario.
 *
 * Esta implementación actual proporciona métodos de acceso para obtener el tipo de jugador y el turno del usuario.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */

public class User {
    /** El nombre del jugador asociado con el usuario. */
    private String userName;

    /**
     * Obtiene el nombre de jugador asociado con el usuario.
     *
     * @return El nombre de jugador asociado con el usuario.
     */
    public String getUserName() {
        return userName;
    }
    /**
     * Obtiene el tipo de jugador asociado con el usuario.
     *
     * @return El tipo de jugador asociado con el usuario.
     */
    public String getTypePlayer() {
        return null;
    }

    /**
     * Obtiene el turno asociado con el usuario.
     *
     * @return El turno asociado con el usuario.
     */
    public Turn getTurn() {
        return null;
    }
    /**
     * Setea el nombre del usuario.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

}