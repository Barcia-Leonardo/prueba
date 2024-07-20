package model.board;
import model.player.Player;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa una ficha en el juego.
 *
 * Una ficha puede tener una posición en el tablero, una cantidad de dinero y un estado de activación.
 * Se utiliza para representar a los jugadores en el juego.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */
public class Pawn implements Serializable {

    private int position;


    private Integer money;


    private boolean isActive;

    private Player player;

    private List<Property> propertiesOwned = new ArrayList<>();


    public List<Property> getPropertiesOwned() {
        return propertiesOwned;
    }

    public Pawn(int position, Integer money, boolean isActive) {
        this.position = position;
        this.money = money;
        this.isActive = isActive;
    }

    public Pawn(){}

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Integer getMoney() {
        return money;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

//    public Property getProperty() {
//         return null;
//    }
    public void mostrarPosicion() {
        System.out.println("La ficha de " + player.getplayerName() + " está en la posición " + position);
    }
    public void movePawn(int steps) {
        position = (position + steps) % 42;
    }

}