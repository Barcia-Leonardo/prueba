package model.board;

public enum RankCard {

    PROFIT("Ganancia"),
    TAX("Impuesto"),
    PRISON("Prision"),
    GET_OUT("Salir de la carcel"),
    MOVE_BOX("Mover casilla");


    private final String classCard;

    RankCard(String classCard) {
        this.classCard = classCard;
    }
}
