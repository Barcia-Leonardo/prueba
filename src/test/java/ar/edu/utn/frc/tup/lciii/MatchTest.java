package ar.edu.utn.frc.tup.lciii;

import model.Match;
import model.board.*;
import model.player.Player;
import model.player.PlayerGame;
import model.player.TypePlayer;
import model.support.Difficulty;
import model.support.Zone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MatchTest {

    private Match match;
    private Player humanPlayer;

    @BeforeEach
    void setUp() {
        match = new Match();
        humanPlayer = new Player("Human Player", TypePlayer.HUMAN, 0, new Pawn(0, 35000, true), null);
    }

    @Test
    void testSetDifficulty_Easy() {
        match.setDifficulty(Difficulty.FACIL, humanPlayer);
        List<Player> players = match.getPlayers();

        assertEquals(3, players.size());
        assertEquals(TypePlayer.HUMAN, players.get(0).getTypePlayer());
        assertEquals(TypePlayer.BALANCED, players.get(1).getTypePlayer());
        assertEquals(TypePlayer.CONSERVATIVE, players.get(2).getTypePlayer());
    }

    @Test
    void testSetDifficulty_Medium() {
        match.setDifficulty(Difficulty.MEDIO, humanPlayer);
        List<Player> players = match.getPlayers();

        assertEquals(4, players.size());
        assertEquals(TypePlayer.HUMAN, players.get(0).getTypePlayer());
        assertEquals(TypePlayer.BALANCED, players.get(1).getTypePlayer());
        assertEquals(TypePlayer.CONSERVATIVE, players.get(2).getTypePlayer());
        assertEquals(TypePlayer.AGGRESSIVE, players.get(3).getTypePlayer());
    }

    @Test
    void testSetDifficulty_Hard() {
        match.setDifficulty(Difficulty.DIFICIL, humanPlayer);
        List<Player> players = match.getPlayers();

        assertEquals(5, players.size());
        assertEquals(TypePlayer.HUMAN, players.get(0).getTypePlayer());
        assertEquals(TypePlayer.BALANCED, players.get(1).getTypePlayer());
        assertEquals(TypePlayer.CONSERVATIVE, players.get(2).getTypePlayer());
        assertEquals(TypePlayer.CONSERVATIVE, players.get(3).getTypePlayer());
        assertEquals(TypePlayer.AGGRESSIVE, players.get(4).getTypePlayer());
    }

//    @Test
//    void testSetTurns() {
//        Player player1 = mock(Player.class);
//        Player player2 = mock(Player.class);
//        Player player3 = mock(Player.class);
//
//        when(player1.getplayerName()).thenReturn("Player 1");
//        when(player2.getplayerName()).thenReturn("Player 2");
//        when(player3.getplayerName()).thenReturn("Player 3");
//
//        match.setPlayers(List.of(player1, player2, player3));
//        match.setTurns();
//
//        verify(player1, atLeastOnce()).setTurn(anyInt());
//        verify(player2, atLeastOnce()).setTurn(anyInt());
//        verify(player3, atLeastOnce()).setTurn(anyInt());
//    }

    @Test
    void testMovePlayerOnBoard() {
        Pawn pawn = new Pawn(0, 35000, true);
        Board board = match.getBoard();
        match.setBoard(board);

        match.movePlayerOnBoard(5, pawn);
        assertEquals(5, pawn.getPosition());

        match.movePlayerOnBoard(37, pawn);
        assertEquals(0, pawn.getPosition());
    }

//    @Test
//    void testExecuteBox_Property() {
//        Property property = mock(Property.class);
//        when(property.viewProperty()).thenReturn("Property Test");
//
//        Player currentPlayer = mock(Player.class);
//        PlayerGame playerGame = mock(PlayerGame.class);
//        when(currentPlayer.getPlayerGame()).thenReturn(playerGame);
//        when(currentPlayer.getTypePlayer()).thenReturn(TypePlayer.HUMAN);
//
//        match.getBoard().getBoxes().set(0, property);
//        match.executeBox(0, currentPlayer);
//
//        verify(playerGame).accionPropertyBuy(eq(property), any(), eq(TypePlayer.HUMAN));
//    }
    
    @Test
    void testPropertiesAvailableForUpgrade(){
        Match match = new Match();
        Player player = new Player("TestPlayer", TypePlayer.HUMAN, 9, new Pawn(), match.getPlayers());
        player.getPlayerGame().addProperty(new Property(Provinces.CORDOBA, Zone.SUR, 6000, 500, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//23
        player.getPlayerGame().addProperty(new Property(Provinces.CORDOBA, Zone.CENTRO, 6000, 450, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//24
        player.getPlayerGame().addProperty(new Property(Provinces.CORDOBA, Zone.NORTE, 6400, 550, TypeProperty.ESCRITURA,  TypeUpgradePropertyEnum.VACIA));//25
        player.getPlayerGame().addProperty(new Property(Provinces.MENDOZA, Zone.SUR,3400, 250, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//11
        player.getPlayerGame().addProperty(new Property(Provinces.MENDOZA, Zone.CENTRO, 3400, 250,  TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//13
        player.getPlayerGame().addProperty(new Property(Provinces.MENDOZA, Zone.NORTE, 3800, 300, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//14

        List<Property> propertiesToUpgrade = match.getPropertiesForUpgrade(player);
        assertNotNull(propertiesToUpgrade);
        assertEquals(6, propertiesToUpgrade.size());

    }
    @Test
    void testPropertiesNotAvailableForUpgrade(){
        Match match = new Match();
        Player player = new Player("TestPlayer", TypePlayer.HUMAN, 9, new Pawn(), match.getPlayers());
        player.getPlayerGame().addProperty(new Property(Provinces.CORDOBA, Zone.SUR, 6000, 500, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//23
        player.getPlayerGame().addProperty(new Property(Provinces.CORDOBA, Zone.NORTE, 6400, 550, TypeProperty.ESCRITURA,  TypeUpgradePropertyEnum.VACIA));//25
        player.getPlayerGame().addProperty(new Property(Provinces.MENDOZA, Zone.SUR,3400, 250, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//11
        player.getPlayerGame().addProperty(new Property(Provinces.MENDOZA, Zone.NORTE, 3800, 300, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//14

        List<Property> propertiesToUpgrade = match.getPropertiesForUpgrade(player);
        assertNotNull(propertiesToUpgrade);
        assertEquals(0, propertiesToUpgrade.size());
    }
}
