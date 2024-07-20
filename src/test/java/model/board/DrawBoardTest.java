package model.board;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class DrawBoardTest {

    @Test
    void testMostrarTablero() {
        DrawBoard drawBoard = new DrawBoard();
        assertDoesNotThrow(drawBoard::mostrarTablero);
    }
}
