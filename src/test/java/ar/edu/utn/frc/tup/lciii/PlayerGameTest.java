package ar.edu.utn.frc.tup.lciii;

import com.sun.xml.bind.v2.TODO;
import model.LetterByLetterPrinter;
import model.board.Provinces;
import model.board.TypeProperty;
import model.board.TypeUpgradePropertyEnum;
import model.support.Zone;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import model.board.Property;
import model.player.Player;
import model.player.PlayerGame;
import model.player.TypePlayer;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayerGameTest {

    @Mock
    private Property property;

    @Mock
    private LetterByLetterPrinter letterByLetterPrinter;

    private PlayerGame playerGame;
    private List<Player> players;
    private List<Property> properties;

    @Before
    public void setUp() {
        players = new ArrayList<>();
        playerGame = new PlayerGame(players);
        MockitoAnnotations.openMocks(this);

        when(property.getValue()).thenReturn(1000);
        when(property.viewProperty()).thenReturn("Property1");
        properties.add(property);
        playerGame.setProperties(properties);

        mockStatic(LetterByLetterPrinter.class);
    }

    @Test
    public void testGetScore() {
        playerGame.setScore(100);
        assertEquals(Integer.valueOf(100), playerGame.getScore());
    }

    @Test
    public void testGetGamesWon() {
        playerGame.setGamesWon(5);
        assertEquals(Integer.valueOf(5), playerGame.getGamesWon());
    }

    @Test
    public void testGetMoney() {
        playerGame.setMoney(50000);
        assertEquals(Integer.valueOf(50000), playerGame.getMoney());
    }
    //TODO: rever test ya que fue modficado el metodo
//    @Test
//    public void testAddAndHasProperty() {
//        Property property = new Property(); // Asumiendo que tienes una clase Property
//        playerGame.addProperty(property);
//        assertTrue(playerGame.hasProperty(property));
//    }

    @Test
    public void testPayMoney() {
        playerGame.setMoney(35000);
        playerGame.payMoney(5000);
        assertEquals(Integer.valueOf(30000), playerGame.getMoney());
    }

    @Test
    public void testReceiveMoney() {
        playerGame.setMoney(35000);
        playerGame.receiveMoney(5000);
        assertEquals(Integer.valueOf(40000), playerGame.getMoney());
    }
    @Test
    public void testAddPatrimony(){
        Integer firstPatrimony = playerGame.getPatrimony();
        playerGame.addPatrimony(1500);
        Integer secondPatrimony = playerGame.getPatrimony();
        assertNotEquals(firstPatrimony, secondPatrimony);
    }
    @Test
    public void testRestPatrimony(){
        Integer firstPatrimony = playerGame.getPatrimony();
        playerGame.restPatrimony(1500);
        Integer secondPatrimony = playerGame.getPatrimony();
        assertNotEquals(firstPatrimony, secondPatrimony);
    }
    @Test
    public void testAddProperty(){
        int sizeFirstProperties = playerGame.getProperties().size();
        playerGame.addProperty(new Property(Provinces.MENDOZA, Zone.SUR,3400, 250, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));
        int sizeSecondProperties = playerGame.getProperties().size();
        assertNotEquals(sizeFirstProperties, sizeSecondProperties);
        assertEquals(sizeFirstProperties, sizeSecondProperties - 1);
    }
    @Test
    public void testUpgradeProperty(){
        playerGame.addProperty(new Property(Provinces.MENDOZA, Zone.SUR, 3400, 250, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));
        playerGame.addProperty(new Property(Provinces.MENDOZA, Zone.SUR, 3400, 250, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.CHACRA));
        playerGame.addProperty(new Property(Provinces.MENDOZA, Zone.SUR, 3400, 250, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.DOS_CHACRAS));
        playerGame.addProperty(new Property(Provinces.MENDOZA, Zone.SUR, 3400, 250, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.ESTANCIA));

        Property propToUpgrade = playerGame.getProperties().get(0);
        playerGame.upgradeProperty(List.of(propToUpgrade));
        assertEquals(TypeUpgradePropertyEnum.CHACRA, propToUpgrade.getTypeUpgradeProperty());

        propToUpgrade = playerGame.getProperties().get(1);
        playerGame.upgradeProperty(List.of(propToUpgrade));
        assertEquals(TypeUpgradePropertyEnum.DOS_CHACRAS, propToUpgrade.getTypeUpgradeProperty());

        propToUpgrade = playerGame.getProperties().get(2);
        playerGame.upgradeProperty(List.of(propToUpgrade));
        assertEquals(TypeUpgradePropertyEnum.ESTANCIA, propToUpgrade.getTypeUpgradeProperty());

        propToUpgrade = playerGame.getProperties().get(3);
        playerGame.upgradeProperty(List.of(propToUpgrade));
        assertEquals(TypeUpgradePropertyEnum.ESTANCIA, propToUpgrade.getTypeUpgradeProperty());
    }
 }

