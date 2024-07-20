package ar.edu.utn.frc.tup.lciii;

import model.board.Provinces;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProvincesTest {

    @Test
    void testProvinces() {
        Assertions.assertEquals(1, Provinces.FORMOSA.getIdProvinces());
        assertEquals("Formosa", Provinces.FORMOSA.getNameProvinces());
    }

    @Test
    void testGetNameListProvinces() {
        // Deberías ajustar este test según la implementación real del método getNameListProvinces
        assertTrue(Provinces.FORMOSA.getNameListProvinces().isEmpty());
    }
}