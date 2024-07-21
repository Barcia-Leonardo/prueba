package model.player.boots;

import model.board.*;
import model.player.Aggresive;
import model.player.Conservative;
import model.player.Player;
import model.player.TypePlayer;
import model.support.Turn;
import model.support.Zone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

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
    void purchaseDecisionTrue() {
        Conservative conservative = new Conservative("TestPlayer", TypePlayer.CONSERVATIVE, 1, new Pawn(), new ArrayList<>());
        Property property = new Property(Provinces.FORMOSA, Zone.SUR, 1000, 100, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA);

        boolean decision = conservative.purchaseDecision(property, BigDecimal.valueOf(5000));
        Assertions.assertTrue(decision);
        Property property2 = new Property(Provinces.BUENOSAIRES, Zone.SUR, 1000, 100, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA);

        boolean decision2 = conservative.purchaseDecision(property2, BigDecimal.valueOf(5000));
        Assertions.assertTrue(decision2);

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