package model.board;

/**
 * Esta clase representa un tipo de casilla en el juego.
 *
 * Un tipo de casilla tiene un nombre asociado.
 * Se utiliza para identificar diferentes tipos de casillas en el juego.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */
public enum TypeBox {

    PROPERTIE("Propiedad"),
    DESTINY("Destino"),
    LUCK("Suerte"),
    SPECIAL("Especial"),
    RAILWAY("Ferrocarril"),
    PRIZE("Premio"),
    TAX("Impuesto"),
    FREE("Libre"),
    GOTOPRISON("Ir a la cárcel"),
    EXIT("Salida");


    private final String typeBox;

    TypeBox(String typeBox) {
        this.typeBox = typeBox;
    }

    public String getTypeBox() {
        return typeBox;
    }

    public void viewProperty() {
        switch (this) {
            case PROPERTIE:
                System.out.println("Esta casilla es una propiedad.");
                break;
            case DESTINY:
                System.out.println("Esta casilla representa el destino.");
                break;
            case LUCK:
                System.out.println("Esta casilla representa la suerte.");
                break;
            case TAX:
                System.out.println("Esta casilla implica pagar impuestos.");
                break;
            case FREE:
                System.out.println("Esta casilla es libre.");
                break;
            case GOTOPRISON:
                System.out.println("Esta casilla te envía a la cárcel.");
                break;
            case EXIT:
                System.out.println("Esta casilla es la salida.");
                break;
            default:
                System.out.println("Esta casilla es de tipo " + typeBox + ".");
                break;
        }
    }
}