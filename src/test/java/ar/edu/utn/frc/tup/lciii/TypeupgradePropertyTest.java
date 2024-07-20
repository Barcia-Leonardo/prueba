package ar.edu.utn.frc.tup.lciii;

import model.board.TypeUpgradeProperty;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TypeUpgradePropertyTest {

    @Test
    void testTypeUpgradeProperty() {
        TypeUpgradeProperty upgrade = new TypeUpgradeProperty("Basica");
        assertEquals("Basica", upgrade.getTypeUpgrade());
    }

    @Test
    void testViewStateProperty() {
        TypeUpgradeProperty upgrade = new TypeUpgradeProperty("Basica", "Estado Inicial");
        assertEquals("Estado Inicial", upgrade.viewStateProperty());
    }
    @Test
    public void testConstructorWithStateProperty() {
        TypeUpgradeProperty upgradeProperty = new TypeUpgradeProperty("Basica", "Estado Inicial");
        assertEquals("Basica", upgradeProperty.getType());
        assertEquals("Estado Inicial", upgradeProperty.viewStateProperty());
    }

    @Test
    public void testConstructorWithoutStateProperty() {
        TypeUpgradeProperty upgradeProperty = new TypeUpgradeProperty("Basica");
        assertEquals("Basica", upgradeProperty.getType());
        assertEquals(null, upgradeProperty.viewStateProperty());
    }

    @Test
    public void testGetType() {
        TypeUpgradeProperty upgradeProperty = new TypeUpgradeProperty("Basica", "Estado Inicial");
        assertEquals("Basica", upgradeProperty.getType());
    }

    @Test
    public void testSetType() {
        TypeUpgradeProperty upgradeProperty = new TypeUpgradeProperty("Basica", "Estado Inicial");
        upgradeProperty.setType("Basica_Modificado");
        assertEquals("Basica_Modificado", upgradeProperty.getType());
    }

    @Test
    public void testGetTypeUpgrade() {
        TypeUpgradeProperty upgradeProperty = new TypeUpgradeProperty("Basica");
        assertEquals("Basica", upgradeProperty.getTypeUpgrade());
    }


    @Test
    public void testShowUpgradeType() {
        TypeUpgradeProperty upgradeProperty = new TypeUpgradeProperty("Basica");
        assertEquals("Tipo de mejora: Basica", upgradeProperty.showUpgradeType());
    }

    @Test
    public void testToString() {
        TypeUpgradeProperty upgradeProperty = new TypeUpgradeProperty("Basica", "Basica");
        assertEquals("Tipo de mejora: Basica Estado de Propiedad: Basica", upgradeProperty.toString());
    }
}