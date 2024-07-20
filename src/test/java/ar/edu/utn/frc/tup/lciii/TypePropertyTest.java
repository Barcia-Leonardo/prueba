package ar.edu.utn.frc.tup.lciii;

import model.board.Property;
import model.board.TypeProperty;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TypePropertyTest {

    @Test
    void testTypeProperty() {
        assertEquals("Escritura", TypeProperty.ESCRITURA.getTypeUpgrade());
    }

    @Test
    void testConsultValueProperty() {
        Property property = new Property();
        property.setValue(1000);
        assertEquals(1000, TypeProperty.ESCRITURA.consultValueProperty(property));
    }
}