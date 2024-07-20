package model.player.boots;

import model.board.*;
import model.player.Balanced;
import model.player.TypePlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class BootBalancedTest {

    @Test
    void listProvincepreferred() {
        Balanced balanced = new Balanced("testPlayer", TypePlayer.BALANCED,1,new Pawn(),new ArrayList<>());
        List<Provinces> preferredProvinces = balanced.listProvincepreferred();

        Assertions.assertNotNull(preferredProvinces);
        Assertions.assertFalse(preferredProvinces.isEmpty());
        Assertions.assertTrue(preferredProvinces.contains(Provinces.MENDOZA));
        Assertions.assertTrue(preferredProvinces.contains(Provinces.SANTAFE));
        Assertions.assertTrue(preferredProvinces.contains(Provinces.TUCUMAN));
    }

    @Test
    void purchaseDecision() {
        Balanced balanced =new Balanced ("TestPlayer", TypePlayer.BALANCED, 1, new Pawn(), new ArrayList<>());

        // Test when property is in preferred provinces
        Property propertyPreferred = new Property("TestProperty", Provinces.FORMOSA, BigDecimal.valueOf(1000), TypeProperty.ESCRITURA);
        boolean decisionPreferred = balanced.purchaseDecision(propertyPreferred, BigDecimal.valueOf(5000));
        Assertions.assertTrue(decisionPreferred);

        // Test when property type is FERROCARRIL
        Property propertyRailroad = new Property("Railroad", Provinces.FORMOSA, BigDecimal.valueOf(2000), TypeProperty.FERROCARRIL);
        boolean decisionRailroad = balanced.purchaseDecision(propertyRailroad, BigDecimal.valueOf(5000));
        Assertions.assertTrue(decisionRailroad);

        // Test when property is not in preferred provinces and not a FERROCARRIL
        Property propertyNotPreferred = new Property("TestProperty2", Provinces.BUENOSAIRES, BigDecimal.valueOf(2000), TypeProperty.ESCRITURA);
        boolean decisionNotPreferred = balanced.purchaseDecision(propertyNotPreferred, BigDecimal.valueOf(5000));
        Assertions.assertFalse(decisionNotPreferred);
    }

    @Test
    void mejoraDecision() {
        Balanced balanced = new Balanced ("TestPlayer", TypePlayer.BALANCED, 1, new Pawn(), new ArrayList<>());

        boolean decision1 = balanced.mejoraDecision(new Property(), 200, 1000);
        Assertions.assertTrue(decision1);
        boolean decision4 = balanced.mejoraDecision(new Property(), 400, 1000);
        Assertions.assertTrue(decision4);
    }
}