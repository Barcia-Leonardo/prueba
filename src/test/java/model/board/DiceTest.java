package model.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {
    private Dice dice;

    @BeforeEach
    public void setUp() {
        dice = new Dice();
    }

    @Test
    public void testRollDice() {
        dice.rollDice();
        assertTrue(dice.getDiceOne() >= 1 && dice.getDiceOne() <= 6);
        assertTrue(dice.getDiceTwo() >= 1 && dice.getDiceTwo() <= 6);
    }

    @Test
    public void testGetDiceEquals() {
        dice.rollDice();
        boolean equals = dice.getDiceEquals();
        assertEquals(equals, dice.getDiceOne() == dice.getDiceTwo());
    }

    @Test
    public void testGetTotalDices() {
        dice.rollDice();
        int total = dice.getTotalDices();
        assertEquals(total, dice.getDiceOne() + dice.getDiceTwo());
    }
}