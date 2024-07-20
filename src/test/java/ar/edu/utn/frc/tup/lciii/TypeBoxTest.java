package ar.edu.utn.frc.tup.lciii;

import model.board.TypeBox;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TypeBoxTest {

    @Test
    void testTypeBox() {
        assertEquals("Propiedad", TypeBox.PROPERTIE.getTypeBox());
    }

    @Test
    void testViewProperty() {
        assertDoesNotThrow(TypeBox.PROPERTIE::viewProperty);
    }
}
