package model.support;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnTest {

    @Test
    void getTurn() {
        Turn turn = new Turn();
        turn.setTurn(1);
        assertEquals(1, turn.getTurn());
    }

    @Test
    void setTurn() {
        Turn turn = new Turn();
        turn.setTurn(2);
        assertEquals(2, turn.getTurn());
    }
}