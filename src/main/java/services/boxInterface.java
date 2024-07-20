package services;

import model.board.Pawn;
import model.board.Property;
import model.board.TypeBox;

import java.util.ArrayList;

/**
 * Esta interfaz define el contrato para las casillas en el juego.
 *
 * Las casillas deben ser capaces de verificar su estado, proporcionar una lista de peones presentes en ellas
 * y devolver el tipo de casilla al que pertenecen.
 *
 * Implementar esta interfaz permite a las clases que representan casillas en el juego cumplir con estas funciones.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */
public interface boxInterface {

    /**
     * Obtiene los peones presentes en la casilla.
     *
     * @return Un array de peones presentes en la casilla.
     */
    ArrayList<Pawn> getPawns();

    /**
     * Obtiene el tipo de casilla al que pertenece.
     *
     * @return El tipo de casilla al que pertenece.
     */
    TypeBox getTypeBox();

    /**
     * Obtiene las propiedades asociadas con la casilla.
     *
     * @return Un array de propiedades asociadas con la casilla.
     */
    Property getProperty();
}
