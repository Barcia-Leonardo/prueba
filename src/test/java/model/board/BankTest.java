package model.board;

import model.support.Zone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    private Bank bank;
    private Property property1;
    private Property property2;
    private TypeUpgradePropertyEnum typeUpgradeProperty;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
        typeUpgradeProperty = TypeUpgradePropertyEnum.VACIA;
        
        property1 = new Property(
                Provinces.CORDOBA,
                Zone.NORTE,
                100000,
                5000,
                TypeProperty.COMPAÑIA,
                typeUpgradeProperty
        );

        property2 = new Property(
                Provinces.CORDOBA,
                Zone.CENTRO,
                150000,
                7000,
                TypeProperty.ESCRITURA,
                typeUpgradeProperty
        );
    }


    //Constructor: 1
    @Test
    public void testBankInitialization() {
        assertEquals("Argentina", bank.getBank());
        assertEquals(BigDecimal.valueOf(999999999), bank.getMoney());
        assertTrue(bank.getProperties().isEmpty());
    }

    //GetBank 2
    @Test
    public void testGetBank() {
        assertEquals("Argentina", bank.getBank());
    }

    //SetBank 3
    @Test
    public void testSetBank() {
        bank.setBank("Banco Nacional");
        assertEquals("Banco Nacional", bank.getBank());
    }

    // GetMoney 4
    @Test
    public void testGetMoney() {
        assertEquals(BigDecimal.valueOf(999999999), bank.getMoney());
    }



    //SetMoney 5
    @Test
    public void testSetMoney() {
        bank.setMoney(BigDecimal.valueOf(500000000));
        assertEquals(BigDecimal.valueOf(500000000), bank.getMoney());
    }



    //6
    @Test
    public void testGetProperties() {
        bank.addProperty(property1);
        bank.addProperty(property2);

        List<Property> properties = bank.getProperties();

        assertEquals(2, properties.size());
        assertTrue(properties.contains(property1));
        assertTrue(properties.contains(property2));
    }

    //7
    @Test
    public void testAddProperty() {
        bank.addProperty(property1);
        List<Property> properties = bank.getProperties();
        assertTrue(properties.contains(property1));
    }


    //8
    @Test
    public void testRemoveProperty() {
        bank.addProperty(property1);
        assertTrue(bank.removeProperty(property1));
        assertFalse(bank.getProperties().contains(property1));
    }


    //9

    @Test
    public void testHasProperty() {
        bank.addProperty(property1);
        assertTrue(bank.hasProperty(property1));

        bank.removeProperty(property1);
        assertFalse(bank.hasProperty(property1));
    }

    // 10
    @Test
    public void testGetProperty() {
        bank.addProperty(property1);
        assertEquals(property1, bank.getProperty());
        bank.removeProperty(property1);
        assertNull(bank.getProperty());
    }
}
