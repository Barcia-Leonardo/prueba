package model.support;

import java.io.Serializable;

/**
 * Esta clase representa un turno en el juego.
 *
 * Un turno tiene un nombre asociado.
 * Se utiliza para identificar diferentes turnos en el juego.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */

public class Turn implements Serializable {
    /** El nombre del turno. */
    private Integer turn;

    /**
     * Obtiene el nombre del turno.
     *
     * @return El nombre del turno.
     */
    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }
}