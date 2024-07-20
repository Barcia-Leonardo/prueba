package model.board;
/**
 * Esta clase representa un tipo de carta en el juego.
 *
 * Un tipo de carta tiene un nombre asociado.
 * Se utiliza para identificar diferentes tipos de cartas en el juego.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */
public enum TypeCard {

    DESTINITY("Destino"),
    LUCK("Suerte");

    /** El nombre del tipo de carta. */

    private final String typeCard;

    TypeCard(String typeCard) {
        this.typeCard = typeCard;
    }

    /**
     * Obtiene el nombre del tipo de carta.
     *
     * @return El nombre del tipo de carta.
     */
    public String getTypeCard() {
        return typeCard;
    }
}