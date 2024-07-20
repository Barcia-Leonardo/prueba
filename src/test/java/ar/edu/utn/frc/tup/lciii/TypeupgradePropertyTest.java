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
}