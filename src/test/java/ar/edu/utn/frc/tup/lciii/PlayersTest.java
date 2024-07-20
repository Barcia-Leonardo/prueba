package ar.edu.utn.frc.tup.lciii;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import model.board.Pawn;
import model.player.Player;
import model.player.TypePlayer;

import java.util.ArrayList;
import java.util.List;

public class PlayersTest {

    private Player player;
    private List<Player> players;
    private Pawn pawn;

    @Before
    public void setUp() {
        players = new ArrayList<>();
        pawn = new Pawn(); // Asumiendo que tienes una clase Pawn
        player = new Player("John", TypePlayer.HUMAN, 1, pawn, players);
    }

    @Test
    public void testGetPlayerName() {
        assertEquals("John", player.getplayerName());
    }

    @Test
    public void testGetTypePlayer() {
        assertEquals(TypePlayer.HUMAN, player.getTypePlayer());
    }

    @Test
    public void testGetTurn() {
        assertEquals(Integer.valueOf(1), player.getTurn());
    }

    @Test
    public void testToString() {
        assertEquals("John", player.toString());
    }

    @Test
    public void testSetPrisonTurns() {
        player.setPrisonTurns(2);
        assertEquals(2, player.getPrisonTurns());
    }

    @Test
    public void testGetPrisonTurns() {
        player.setPrisonTurns(2);
        assertEquals(2, player.getPrisonTurns());
    }

    @Test
    public void testDecrementPrisonTurnsWhenGreaterThanZero() {
        player.setPrisonTurns(3);
        player.decrementPrisonTurns();
        assertEquals(2, player.getPrisonTurns());
    }

    @Test
    public void testDecrementPrisonTurnsWhenZero() {
        player.setPrisonTurns(0);
        player.decrementPrisonTurns();
        assertEquals(0, player.getPrisonTurns());
    }

    @Test
    public void testDecrementPrisonTurnsWhenNegative() {
        player.setPrisonTurns(-1);
        player.decrementPrisonTurns();
        assertEquals(-1, player.getPrisonTurns());
    }
}
