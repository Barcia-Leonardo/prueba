package model.board;

import model.player.Player;
import model.player.TypePlayer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    void testPawnInitialization() {
        Pawn pawn = new Pawn(5, 1000, true);
        assertEquals(5, pawn.getPosition());
        assertEquals(1000, pawn.getMoney());
        assertTrue(pawn.isActive());
    }

    @Test
    void testMovePawn() {
        Pawn pawn = new Pawn(0, 1000, true);
        pawn.movePawn(10);
        assertEquals(10, pawn.getPosition());
        pawn.movePawn(32); // Debería volver a 0 (42 casillas en el tablero)
        assertEquals(0, pawn.getPosition());
    }

    @Test
    void testSettersAndGetters() {
        Pawn pawn = new Pawn();
        pawn.setPosition(10);
        pawn.setActive(false);
        assertEquals(10, pawn.getPosition());
        assertFalse(pawn.isActive());
    }

    @Test
    void testMostrarPosicion() {
        Player player = new Player("Player1", TypePlayer.HUMAN, 0,null, null);
        Pawn pawn = new Pawn(5, 1000, true);
        pawn.setPlayer(player);
        assertDoesNotThrow(pawn::mostrarPosicion);
    }
}
