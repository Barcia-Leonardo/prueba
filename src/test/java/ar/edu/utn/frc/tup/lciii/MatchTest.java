package ar.edu.utn.frc.tup.lciii;

import model.Match;
import model.board.*;
import model.player.Player;
import model.player.PlayerGame;
import model.player.TypePlayer;
import model.support.Difficulty;
import model.board.Provinces;
import model.board.TypeProperty;
import model.board.TypeUpgradePropertyEnum;
import model.support.Zone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


class MatchTest {

    private Match match;
    private Player humanPlayer;
    private Scanner scannerMock;
    private Board board;
    private Box box;

    @BeforeEach
    void setUp() {
        match = new Match();
        humanPlayer = new Player("Human Player", TypePlayer.HUMAN, 0, new Pawn(0, 35000, true), null);
        board = mock(Board.class);
        box = mock(Box.class);
        scannerMock = new Scanner(System.in);
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

    @Test
    public void testSetTurns() {
        match.setDifficulty(Difficulty.FACIL, humanPlayer);
        match.setTurns();
        assertEquals(3, match.getPlayers().size());
    }

    @Test
    public void testExecuteBox() {
        match.setDifficulty(Difficulty.FACIL, humanPlayer);
        match.setTurns();
        Player currentPlayer = match.getPlayers().get(0);
        match.executeBox(7, currentPlayer);
        assertEquals(37500, currentPlayer.getPlayerGame().getMoney());
    }

    @Test
    public void testAccionPrisonAction() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        match.setDifficulty(Difficulty.FACIL, humanPlayer);
        match.setTurns();
        Player currentPlayer = match.getPlayers().get(0);
        match.executeBox(7, currentPlayer);

        Method method = match.getClass().getDeclaredMethod("accionPrisonAction", Player.class);
        method.setAccessible(true);
        method.invoke(match, currentPlayer);
        assertFalse(currentPlayer.getPawn().isActive());
        assertEquals(14, currentPlayer.getPawn().getPosition());
    }

    @Test
    public void testPrisonTurn() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        match.setDifficulty(Difficulty.FACIL, humanPlayer);
        match.setTurns();
        Player currentPlayer = match.getPlayers().get(0);
        match.executeBox(7, currentPlayer);
        match.accionPrisonAction(currentPlayer);

        Method method = match.getClass().getDeclaredMethod("PrisonTurn", Player.class);
        method.setAccessible(true);
        method.invoke(match, currentPlayer);
        assertEquals(0, currentPlayer.getPrisonTurns());
    }

    @Test
    public void testAccionFreeAction() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        match.setDifficulty(Difficulty.FACIL, humanPlayer);
        match.setTurns();
        Player currentPlayer = match.getPlayers().get(0);
        match.executeBox(14, currentPlayer);

        Method method = match.getClass().getDeclaredMethod("accionFreeAction", Integer.class);
        method.setAccessible(true);
        method.invoke(match, currentPlayer.getPawn().getPosition());
    }

    @Test
    public void testAccionLuckAction() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        match.setDifficulty(Difficulty.FACIL, humanPlayer);
        match.setTurns();
        Player currentPlayer = match.getPlayers().get(0);
        match.executeBox(20, currentPlayer);

        Method method = match.getClass().getDeclaredMethod("accionLuckAction", Player.class);
        method.setAccessible(true);
        method.invoke(match, currentPlayer);

    }

    @Test
    public void testAccionDestinyAction() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        match.setDifficulty(Difficulty.FACIL, humanPlayer);
        match.setTurns();
        Player currentPlayer = match.getPlayers().get(0);
        match.executeBox(25, currentPlayer);
        Method method = match.getClass().getDeclaredMethod("accionDestinyAction", Player.class);
        method.setAccessible(true);
        method.invoke(match, currentPlayer);
    }

    @Test
    public void testDrawCard() throws NoSuchMethodException{
        match.setDifficulty(Difficulty.FACIL, humanPlayer);
        match.setTurns();
        Method method = match.getClass().getDeclaredMethod("drawCard", TypeCard.class);
        method.setAccessible(true);
    }

    @Test
    public void testProcessCardAction() throws NoSuchMethodException{
        match.setDifficulty(Difficulty.FACIL, humanPlayer);
        match.setTurns();
        Player currentPlayer = match.getPlayers().get(0);
        Method method=match.getClass().getDeclaredMethod("processCardAction", Card.class, Player.class);
        Card card = new Card(TypeCard.LUCK,  RankCard.PROFIT, "Descripción de prueba", 200);
    }


    @Test
    public void testMovePlayerByCard() throws NoSuchMethodException{
        match.setDifficulty(Difficulty.FACIL, humanPlayer);
        match.setTurns();
        Player currentPlayer = match.getPlayers().get(0);
        Card card = new Card(TypeCard.DESTINITY,  RankCard.MOVE_BOX, "Mover 2 casillas hacia adelante",2);
        Method method = match.getClass().getDeclaredMethod("movePlayerByCard", Card.class, Player.class);
    }

    @Test
    public void testAccionPropertyBox() throws NoSuchMethodException{
        match.setDifficulty(Difficulty.FACIL, humanPlayer);
        match.setTurns();
        Player currentPlayer = match.getPlayers().get(0);
        Property property = match.getBoard().getProperties().get(0);
        Method method = match.getClass().getDeclaredMethod("accionPropertyBox", Property.class, Player.class);

    }

    @Test
    public void testFindPropertyOwner()throws NoSuchMethodException {
        match.setDifficulty(Difficulty.FACIL, humanPlayer);
        match.setTurns();
        Player currentPlayer = match.getPlayers().get(0);
        Property property = match.getBoard().getProperties().get(0);
        Method method = match.getClass().getDeclaredMethod("findPropertyOwner", Property.class);
        method.setAccessible(true);
    }

    @Test
    public void testCalculateRent() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        match.setDifficulty(Difficulty.FACIL, humanPlayer);
        match.setTurns();
        Property property = match.getBoard().getProperties().get(0);
        Method method=match.getClass().getDeclaredMethod("calculateRent", Property.class);
        method.setAccessible(true);
        int rent =(int) method.invoke(match, property);
    }

    @Test
    public void testAccionTaxBoxAction()throws NoSuchMethodException {
        match.setDifficulty(Difficulty.FACIL, humanPlayer);
        match.setTurns();
        Player currentPlayer = match.getPlayers().get(0);
        match.executeBox(4, currentPlayer);
        Method method =match.getClass().getDeclaredMethod("accionTaxBoxAction", Player.class, Integer.class);

    }

    @Test
    public void testAccionPrizeBoxAction() throws NoSuchMethodException {
        match.setDifficulty(Difficulty.FACIL, humanPlayer);
        match.setTurns();
        Player currentPlayer = match.getPlayers().get(0);
        match.executeBox(10, currentPlayer);
        Method method = match.getClass().getDeclaredMethod("accionPrizeBoxAction", Player.class);
    }

}
