package ar.edu.utn.frc.tup.lciii;

import model.Match;
import model.MatchMenu;
import model.board.Dice;
import model.board.Pawn;
import model.player.Player;
import model.player.TypePlayer;
import model.support.Difficulty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MatchMenuTest {

    private MatchMenu matchMenu;
    private Match match;
    private Player humanPlayer;
    private Scanner mockScanner;

    @BeforeEach
    public void setUp() {
        matchMenu = new MatchMenu();
        match = Mockito.mock(Match.class);
        humanPlayer = new Player("TestPlayer", TypePlayer.HUMAN, 0, new Pawn(0, 35000, true), new ArrayList<>());
        mockScanner = Mockito.mock(Scanner.class);
        matchMenu.setMatch(match);
    }

    @Test
    public void testWelcomeMessage() {
        // No assert statement is needed as we're only printing a message.
        matchMenu.welcomeMessage();
    }

//    @Test
//    public void testCreatePlayer() {
//        when(mockScanner.nextLine()).thenReturn("TestPlayer");
//        matchMenu.setScanner(mockScanner);
//        Player player = matchMenu.createPlayer();
//        assertNotNull(player);
//        assertEquals("TestPlayer", player.getplayerName());
//    }

    @Test
    public void testStartGame() {
        List<Player> players = new ArrayList<>();
        players.add(humanPlayer);
        when(match.getPlayers()).thenReturn(players);
        matchMenu.startGame();
        verify(match).setTurns();
    }

//    @Test
//    public void testChooseDifficult() {
//        when(mockScanner.next()).thenReturn("1");
//        matchMenu.setScanner(mockScanner);
//        matchMenu.chooseDifficult(humanPlayer);
//        verify(match).setDifficulty(Difficulty.FACIL, humanPlayer);
//    }
//
//    @Test
//    public void testChooseEndingWithLimit() {
//        when(mockScanner.nextLine()).thenReturn("y");
//        when(mockScanner.nextInt()).thenReturn(50000);
//        matchMenu.setScanner(mockScanner);
//        matchMenu.chooseEnding();
//        verify(match).setLimitMoney(50000);
//    }
//
//    @Test
//    public void testChooseEndingWithoutLimit() {
//        when(mockScanner.nextLine()).thenReturn("n");
//        matchMenu.setScanner(mockScanner);
//        matchMenu.chooseEnding();
//        verify(match, never()).setLimitMoney(anyInt());
//    }
//
//    @Test
//    public void testWantPlayAgainYes() {
//        when(mockScanner.nextLine()).thenReturn("y");
//        matchMenu.setScanner(mockScanner);
//        assertTrue(matchMenu.wantPlayAgain());
//    }
//
//    @Test
//    public void testWantPlayAgainNo() {
//        when(mockScanner.nextLine()).thenReturn("n");
//        matchMenu.setScanner(mockScanner);
//        assertFalse(matchMenu.wantPlayAgain());
//    }
//
//    @Test
//    public void testContinuePlayingYes() {
//        when(mockScanner.nextLine()).thenReturn("y");
//        matchMenu.setScanner(mockScanner);
//        assertTrue(matchMenu.continuePlaying());
//    }
//
//    @Test
//    public void testContinuePlayingNo() {
//        when(mockScanner.nextLine()).thenReturn("n");
//        matchMenu.setScanner(mockScanner);
//        assertFalse(matchMenu.continuePlaying());
//    }

    @Test
    public void testPlayGame() {
        Player mockPlayer = Mockito.mock(Player.class);
        Dice mockDice = Mockito.mock(Dice.class);
        List<Player> players = new ArrayList<>();
        players.add(mockPlayer);
        when(mockDice.getTotalDices()).thenReturn(5);
        when(mockPlayer.getPawn()).thenReturn(new Pawn(0, 35000, true));
        when(match.getPlayers()).thenReturn(players);
        matchMenu.playGame();
        verify(mockPlayer.getPawn()).movePawn(5);
        verify(match).executeBox(anyInt(), eq(mockPlayer));
    }

    @Test
    public void testPrintPlayersInfo() {
        Player player = new Player("TestPlayer", TypePlayer.HUMAN, 0, new Pawn(0, 35000, true), new ArrayList<>());
        player.getPlayerGame().receiveMoney(1000);
        List<Player> players = new ArrayList<>();
        players.add(player);
        matchMenu.printPlayersInfo(players);
        // No assertion needed as this method only prints information.
    }

//    @Test
//    public void testMostrarPosiciones() {
//        Player player = new Player("TestPlayer", TypePlayer.HUMAN, 0, new Pawn(0, 35000, true), new ArrayList<>());
//        List<Player> players = new ArrayList<>();
//        players.add(player);
//        matchMenu.mostrarPosiciones(players);
//        // No assertion needed as this method only prints information.
//    }

    @Test
    public void testMovePlayers() {
        Player player = new Player("TestPlayer", TypePlayer.HUMAN, 0, new Pawn(0, 35000, true), new ArrayList<>());
        List<Player> players = new ArrayList<>();
        players.add(player);
        matchMenu.movePlayers(players, 5);
        assertEquals(5, player.getPawn().getPosition());
    }
}
