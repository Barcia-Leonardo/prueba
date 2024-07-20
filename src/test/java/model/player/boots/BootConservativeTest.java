package model.player.boots;

import model.board.*;
import model.player.Conservative;
import model.player.TypePlayer;
import model.support.Zone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class BootConservativeTest {

    @Test
    void listProvincepreferred() {
        Conservative conservative = new Conservative("TestPlayer", TypePlayer.CONSERVATIVE, 1, new Pawn(), new ArrayList<>());
        List<Provinces> preferredProvinces = conservative.listProvincepreferred();

        Assertions.assertNotNull(preferredProvinces);
        Assertions.assertFalse(preferredProvinces.isEmpty());
        Assertions.assertTrue(preferredProvinces.contains(Provinces.FORMOSA));
        Assertions.assertTrue(preferredProvinces.contains(Provinces.RIONEGRO));
        Assertions.assertTrue(preferredProvinces.contains(Provinces.SALTA));
    }

    @Test
    void purchaseDecision() {
        Conservative conservative = new Conservative("TestPlayer", TypePlayer.CONSERVATIVE, 1, new Pawn(), new ArrayList<>());
        Property property = new Property(Provinces.FORMOSA, Zone.SUR, 1000, 100, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA);

        boolean decision = conservative.purchaseDecision(property, BigDecimal.valueOf(5000));
        Assertions.assertTrue(decision);

        property = new Property(Provinces.BUENOSAIRES, Zone.SUR, 2000, 200, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA);
        decision = conservative.purchaseDecision(property, BigDecimal.valueOf(5000));
        Assertions.assertFalse(decision);
    }

    @Test
    void improvements() {
        Conservative conservative = new Conservative("TestPlayer", TypePlayer.CONSERVATIVE, 1, new Pawn(), new ArrayList<>());
        Property property = new Property("TestProperty", Provinces.FORMOSA, BigDecimal.valueOf(1000));

        boolean decision = conservative.improvements(property, 200, 1000);
        Assertions.assertTrue(decision);

        decision = conservative.improvements(property, 400, 1000);
        Assertions.assertFalse(decision);
    }
}