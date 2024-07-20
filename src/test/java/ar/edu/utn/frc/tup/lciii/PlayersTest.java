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
}
