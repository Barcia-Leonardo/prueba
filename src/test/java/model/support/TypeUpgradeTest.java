package model.support;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeUpgradeTest {

    @Test
    void getTypeUpgrade() {
        assertEquals("Chacra", TypeUpgrade.CHACRA.getTypeUpgrade());
        assertEquals("Estancia", TypeUpgrade.ESTANCIA.getTypeUpgrade());
    }

    @Test
    void viewStateProperty() {
        assertEquals("Estado de la propiedad para Chacra", TypeUpgrade.CHACRA.viewStateProperty());
        assertEquals("Estado de la propiedad para Estancia", TypeUpgrade.ESTANCIA.viewStateProperty());

    }

    @Test
    void showUpgradeType() {
        assertEquals("Tipo de mejora: Chacra", TypeUpgrade.CHACRA.showUpgradeType());
        assertEquals("Tipo de mejora: Estancia", TypeUpgrade.ESTANCIA.showUpgradeType());

    }

}