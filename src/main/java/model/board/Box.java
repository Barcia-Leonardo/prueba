package model.board;

import java.io.Serializable;
import java.util.ArrayList;
import services.boxInterface;

/**
 * Esta clase representa una casilla en el tablero de juego.
 *
 * Una casilla puede tener diferentes tipos y puede contener propiedades.
 * Implementa la interfaz boxInterface para proporcionar funcionalidad común a todas las casillas.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */

public class Box implements boxInterface , Serializable {

    private TypeBox typeBox;

    private Property property;

    private ArrayList<Pawn> pawns;

    public Box(TypeBox typeBox, Property property, ArrayList<Pawn> pawns) {
        this.typeBox = typeBox;
        this.property = property;
        this.pawns = pawns;
    }

    @Override
    public ArrayList<Pawn> getPawns() {
        return pawns;
    }

    @Override
    public TypeBox getTypeBox() {
        return typeBox;
    }

    @Override
    public Property getProperty(){
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
