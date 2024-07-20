package ar.edu.utn.frc.tup.lciii;



import model.board.*;
import model.player.Player;
import model.player.PlayerGame;
import model.player.TypePlayer;
import model.support.Zone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;


public class PlayerGameTest {

    @Mock
    private Property mockedProperty;

    @Mock
    private Player mockedPlayer1, mockedPlayer2;

    @Mock
    private Scanner mockedScanner;

    private PlayerGame playerGame;
    private List<Player> players;
    private Property property;

    @BeforeEach
    public void setUp() {
        players = new ArrayList<>();
        playerGame = new PlayerGame(players);

        MockitoAnnotations.openMocks(this);
        players = new ArrayList<>();
        mockedPlayer1 = mock(Player.class);
        mockedPlayer2 = mock(Player.class);
        players.add(mockedPlayer1);
        players.add(mockedPlayer2);
        playerGame.setMoney(1000);
    }

    @Test
    public void testPayMoney() {
        playerGame.setMoney(5000);
        playerGame.payMoney(1000);
        assertEquals(4000, playerGame.getMoney());
    }

    @Test
    public void testReceiveMoney() {
        playerGame.setMoney(5000);
        playerGame.receiveMoney(1000);
        assertEquals(6000, playerGame.getMoney());
    }

    @Test
    public void testAddProperty() {
        property = new Property(Provinces.FORMOSA, Zone.SUR, 1000, 40, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA);
        playerGame.addProperty(property);
        assertTrue(playerGame.getProperties().contains(property));
    }

    @Test
    public void testHasProperty() {
        Property property = new Property(Provinces.SANTAFE, Zone.NORTE, 10, 0, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA);
        playerGame.addProperty(property);
        assertEquals(0, playerGame.hasProperty(property));
    }

    @Test
    public void testAccionPropertyBuy_Human() {
        Property property = new Property(Provinces.SANTAFE, Zone.NORTE, 10, 0, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA);
        playerGame.setMoney(1000);

        Scanner scanner = new Scanner("Y\n"); // Simula la entrada del usuario como "Y"
        playerGame.accionPropertyBuy(property, scanner, TypePlayer.HUMAN);

        assertTrue(playerGame.getProperties().contains(property));
        assertEquals(990, playerGame.getMoney());
    }

    @Test
    public void testAccionTaxPayment() {
        playerGame.setMoney(5000);
        playerGame.setPatrimony(5000);
        playerGame.accionTaxPayment(1000);
        assertEquals(4000, playerGame.getMoney());
        assertEquals(4000, playerGame.getPatrimony());
    }

    @Test
    public void testAccionPrizeCollection() {
        playerGame.setMoney(5000);
        playerGame.setPatrimony(5000);
        playerGame.accionPrizeCollection(1000);
        assertEquals(6000, playerGame.getMoney());
        assertEquals(6000, playerGame.getPatrimony());
    }

    @Test
    public void testSellProperty() {
        Property property = new Property(Provinces.SANTAFE, Zone.NORTE, 0, 0, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA);
        playerGame.addProperty(property);
        playerGame.setMoney(5005);
        playerGame.setPatrimony(5005);


        ByteArrayInputStream in = new ByteArrayInputStream("0\n".getBytes());
        System.setIn(in);


        playerGame.sellProperty();


        System.setIn(System.in);

        assertFalse(playerGame.getProperties().contains(property));
        assertEquals(5005, playerGame.getMoney());
        assertEquals(5005, playerGame.getPatrimony());
    }

    @Test
    public void testUpgradeProperty() {
        Property property = new Property(Provinces.SANTAFE, Zone.NORTE, 10, 0, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA);
        playerGame.addProperty(property);
        playerGame.setMoney(5000);


        ByteArrayInputStream in = new ByteArrayInputStream("0\n".getBytes());
        System.setIn(in);

        List<Property> propertiesToUpgrade = new ArrayList<>();
        propertiesToUpgrade.add(property);

        playerGame.upgradeProperty(propertiesToUpgrade);

        assertEquals(TypeUpgradePropertyEnum.CHACRA, property.getTypeUpgradeProperty());
        assertEquals(4000, playerGame.getMoney());
    }
    @Test
    public void testUpgradeProperty1() {
        Property property = new Property(Provinces.SANTAFE, Zone.NORTE, 10, 0, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.CHACRA);
        playerGame.addProperty(property);
        playerGame.setMoney(5000);


        ByteArrayInputStream in = new ByteArrayInputStream("0\n".getBytes());
        System.setIn(in);

        List<Property> propertiesToUpgrade = new ArrayList<>();
        propertiesToUpgrade.add(property);

        playerGame.upgradeProperty(propertiesToUpgrade);

        assertEquals(TypeUpgradePropertyEnum.DOS_CHACRAS, property.getTypeUpgradeProperty());
        assertEquals(3000, playerGame.getMoney());
    }
    @Test
    public void testUpgradeProperty2() {
        Property property = new Property(Provinces.SANTAFE, Zone.NORTE, 10, 0, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.DOS_CHACRAS);
        playerGame.addProperty(property);
        playerGame.setMoney(5000);

        // Simula la entrada del usuario como "0" (índice de la propiedad)
        ByteArrayInputStream in = new ByteArrayInputStream("0\n".getBytes());
        System.setIn(in);

        List<Property> propertiesToUpgrade = new ArrayList<>();
        propertiesToUpgrade.add(property);

        playerGame.upgradeProperty(propertiesToUpgrade);

        assertEquals(TypeUpgradePropertyEnum.ESTANCIA, property.getTypeUpgradeProperty());
        assertEquals(2000, playerGame.getMoney());
    }
    @Test
    public void testUpgradeProperty3() {
        Property property = new Property(Provinces.SANTAFE, Zone.NORTE, 10, 0, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.ESTANCIA);
        playerGame.addProperty(property);
        playerGame.setMoney(5000);


        ByteArrayInputStream in = new ByteArrayInputStream("0\n".getBytes());
        System.setIn(in);

        List<Property> propertiesToUpgrade = new ArrayList<>();
        propertiesToUpgrade.add(property);

        playerGame.upgradeProperty(propertiesToUpgrade);

        assertEquals(TypeUpgradePropertyEnum.ESTANCIA, property.getTypeUpgradeProperty());
        assertEquals(5000, playerGame.getMoney());
    }

    private void setScannerField(Scanner scanner) {
        try {
            Field scannerField = PlayerGame.class.getDeclaredField("scanner");
            ((Field) scannerField).setAccessible(true);
            scannerField.set(playerGame, scanner);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetEstancias() {

        assertEquals(0, playerGame.getEstancias());
    }

    @Test
    public void testGetChacras() {

        assertEquals(0, playerGame.getChacras());
    }

    @Test
    public void testFindBotPlayerByType() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Player player1 = new Player("Diego", TypePlayer.HUMAN, 2, new Pawn(), null);
        Player player2 = new Player("Leo", TypePlayer.CONSERVATIVE, 2, new Pawn(), null);
        Player player3 = new Player("Mavi", TypePlayer.BALANCED, 2, new Pawn(), null);

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        PlayerGame playerGame = new PlayerGame(players);


        Method method = PlayerGame.class.getDeclaredMethod("findBotPlayerByType", TypePlayer.class, List.class);
        method.setAccessible(true);


        Player foundBot = (Player) method.invoke(playerGame, TypePlayer.CONSERVATIVE, players);
        assertEquals(player2, foundBot);


        Player foundHuman = (Player) method.invoke(playerGame, TypePlayer.HUMAN, players);
        assertEquals(player1, foundHuman);


        Player foundNone = (Player) method.invoke(playerGame, TypePlayer.AGGRESSIVE, players);
        assertNull(foundNone);
    }


}

