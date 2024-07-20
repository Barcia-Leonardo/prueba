package model.player;

import lombok.Data;
import model.board.Pawn;
import services.playerInterface;
import java.io.Serializable;
import java.util.List;

/**
 * Esta clase representa un jugador en el juego.
 *
 * Un jugador tiene un nombre, un tipo y un turno asociado.
 * Implementa la interfaz playerInterface para proporcionar funcionalidad común a todos los jugadores.
 *
 * Esta implementación actual proporciona métodos de acceso para el nombre, el tipo y el turno del jugador.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */
@Data
public class Player  implements playerInterface, Serializable {

    private String playerName;


    private TypePlayer typePlayer;


    private Integer turn;

    private List<Player> players;

    private Pawn pawn;

    private PlayerGame playerGame;

    private int prisonTurns;

    public Player(String playerName, TypePlayer typePlayer, Integer turn, Pawn pawn, List<Player> players) {
        this.playerName = playerName;
        this.typePlayer = typePlayer;
        this.turn = turn;
        this.pawn = pawn;
        this.players = players;
        this.playerGame = new PlayerGame(players);
        this.prisonTurns= 0;
    }

    public Player() {

    }

    public void setPrisonTurns(int prisonTurns) {
        this.prisonTurns = prisonTurns;
    }

    public int getPrisonTurns() {
        return prisonTurns;
    }

    public void decrementPrisonTurns() {
        if(prisonTurns > 0){
            prisonTurns--;
        }
    }

    public boolean isPrison(){
        return prisonTurns > 0;
    }

    @Override
    public String getplayerName() {
        return this.playerName;
    }

    @Override
    public TypePlayer getTypePlayer() {
        return this.typePlayer;
    }


    @Override
    public Integer getTurn() {
        return this.turn;
    }

    @Override
    public String toString() {
        return this.playerName;
    }
}
