package ar.edu.utn.frc.tup.lciii;

import model.*;
import model.board.*;
import model.player.Player;
import model.player.TypePlayer;
import model.support.Difficulty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MatchMenuTest {

    private MatchMenu matchMenu;
    private Scanner scannerMock;
    private Match matchMock;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        scannerMock = mock(Scanner.class);
        matchMock = mock(Match.class);
        matchMenu = new MatchMenu();

        Field scannerField = MatchMenu.class.getDeclaredField("scanner");
        scannerField.setAccessible(true);
        scannerField.set(matchMenu, scannerMock);

        matchMenu.setMatch(matchMock);
    }

    @Test
    public void testWelcomeMessage() {

    }

    @Test
    public void testCreatePlayer() {
        when(scannerMock.nextLine()).thenReturn("John Doe");

        Player player = matchMenu.createPlayer();

        assertEquals("John Doe", player.getplayerName());
        assertEquals(TypePlayer.HUMAN, player.getTypePlayer());
        assertEquals(35000, player.getPlayerGame().getMoney());
        assertNotNull(player.getPawn());
    }

    @Test
    public void testStartGame() {
        matchMenu.startGame();
        verify(matchMock, times(1)).setTurns();
    }

    @Test
    public void testChooseDifficult() {
        Player humanPlayer = new Player("John Doe", TypePlayer.HUMAN, 0, new Pawn(0, 35000, true), Arrays.asList());

        when(scannerMock.next()).thenReturn("1", "2", "3");

        matchMenu.chooseDifficult(humanPlayer);
        verify(matchMock, times(1)).setDifficulty(Difficulty.FACIL, humanPlayer);


        matchMenu.chooseDifficult(humanPlayer);
        verify(matchMock, times(1)).setDifficulty(Difficulty.MEDIO, humanPlayer);

        matchMenu.chooseDifficult(humanPlayer);
        verify(matchMock, times(1)).setDifficulty(Difficulty.DIFICIL, humanPlayer);
    }

    @Test
    public void testChooseEnding() {
        when(scannerMock.nextLine()).thenReturn("n");
        matchMenu.chooseEnding();


    }

    @Test
    public void testWantPlayAgain() {
        when(scannerMock.nextLine()).thenReturn("y");

        Boolean answer = matchMenu.wantPlayAgain();

        assertTrue(answer);
    }

    @Test
    public void testContinuePlaying() {
        when(scannerMock.nextLine()).thenReturn("y");

        Boolean answer = matchMenu.continuePlaying();

        assertTrue(answer);
    }

    @Test
    public void testGetYesNoAnswer() {
        assertTrue(matchMenu.getYesNoAnswer("y"));
        assertTrue(matchMenu.getYesNoAnswer("Y"));
        assertFalse(matchMenu.getYesNoAnswer("n"));
        assertFalse(matchMenu.getYesNoAnswer("N"));
        assertNull(matchMenu.getYesNoAnswer("a"));
    }

    @Test
    public void testPlayGame() {
        Player player1 = new Player("Player 1", TypePlayer.HUMAN, 0, new Pawn(0, 35000, true), Arrays.asList());
        Player player2 = new Player("Player 2", TypePlayer.HUMAN, 0, new Pawn(0, 35000, true), Arrays.asList());
        when(matchMock.getPlayers()).thenReturn(Arrays.asList(player1, player2));
        when(matchMock.getLimitMoney()).thenReturn(50000);

        Dice diceMock = mock(Dice.class);
        when(diceMock.getTotalDices()).thenReturn(5);

        Boolean result = matchMenu.playGame();

        assertFalse(result);
    }

    @Test
    public void testPrintPlayersInfo() {

    }

    @Test
    public void testMovePlayers() {
        Player player1 = new Player("Player 1", TypePlayer.HUMAN, 0, new Pawn(0, 35000, true), Arrays.asList());
        Player player2 = new Player("Player 2", TypePlayer.HUMAN, 0, new Pawn(0, 35000, true), Arrays.asList());

        matchMenu.movePlayers(Arrays.asList(player1, player2), 3);

        assertEquals(3, player1.getPawn().getPosition());
        assertEquals(3, player2.getPawn().getPosition());
    }

    @Test
    public void testAskForDecision() {
        Player player = new Player("Player 1", TypePlayer.HUMAN, 0, new Pawn(0, 35000, true), Arrays.asList());
        when(scannerMock.next()).thenReturn("0");

        matchMenu.askForDecision(player);
    }
}