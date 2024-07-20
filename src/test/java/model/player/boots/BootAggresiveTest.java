package model.player.boots;

import model.board.*;
import model.player.Aggresive;
import model.player.Player;
import model.player.TypePlayer;
import model.support.Zone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BootAggresiveTest {


    private Aggresive aggressivePlayer;
    private Property tucumanProperty;
    private Property cordobaProperty;
    private Property buenosAiresProperty;
    private Property ferrocarrilProperty;
    private Property companiaProperty;

    @BeforeEach
    public void setUp() {
        Player player = new Player("Test Player", TypePlayer.AGGRESSIVE, 1, new Pawn(), new ArrayList<>());
        aggressivePlayer = new Aggresive("Aggressive Player", TypePlayer.AGGRESSIVE, 1, new Pawn(), new ArrayList<>());

        // Crear propiedades de prueba
        tucumanProperty = new Property(Provinces.TUCUMAN, Zone.NORTE, 5400, 450, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.CHACRA);
        cordobaProperty = new Property(Provinces.CORDOBA, Zone.CENTRO, 5000, 450, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.CHACRA);
        buenosAiresProperty = new Property(Provinces.BUENOSAIRES, Zone.NORTE, 7500, 1000,TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.CHACRA);
        ferrocarrilProperty = new Property(Provinces.FERROCARRIL, Zone.SUR, 5500, 1000,TypeProperty.FERROCARRIL, TypeUpgradePropertyEnum.VACIA);
        companiaProperty = new Property(Provinces.COMPANY, Zone.SUR, 5500, 1000,TypeProperty.COMPAÑIA, TypeUpgradePropertyEnum.VACIA);
    }

    @Test
    public void testListProvincePreferred() {
        List<Provinces> expectedProvinces = Arrays.asList(Provinces.TUCUMAN,Provinces.CORDOBA,Provinces.BUENOSAIRES);
        assertEquals(expectedProvinces, aggressivePlayer.listProvincePreferred());
    }

    @Test
    public void testPurchaseDecisionPreferredProvince() {
        BigDecimal cash = BigDecimal.valueOf(500);
        assertTrue(aggressivePlayer.purchaseDecision(tucumanProperty, cash), "Debería decidir comprar la propiedad de Tucuman");
        assertTrue(aggressivePlayer.purchaseDecision(cordobaProperty, cash), "Debería decidir comprar la propiedad de Cordoba");
        assertTrue(aggressivePlayer.purchaseDecision(buenosAiresProperty, cash), "Debería decidir comprar la propiedad de Buenos Aires");
    }

    @Test
    public void testPurchaseDecisionFerrocarril() {
        BigDecimal cash = BigDecimal.valueOf(500);
        assertTrue(aggressivePlayer.purchaseDecision(ferrocarrilProperty, cash), "Debería decidir comprar la propiedad de ferrocarril");
    }

    @Test
    public void testPurchaseDecisionCompania() {
        BigDecimal cash = BigDecimal.valueOf(500);
        assertTrue(aggressivePlayer.purchaseDecision(companiaProperty, cash), "Debería decidir comprar la propiedad de compañía");
    }

    @Test
    public void testPurchaseDecisionNonPreferred() {
        Property nonPreferredProperty = new Property(Provinces.SANTAFE, Zone.CENTRO, 4200,350, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.CHACRA);
        BigDecimal cash = BigDecimal.valueOf(500);
        assertFalse(aggressivePlayer.purchaseDecision(nonPreferredProperty, cash), "No debería decidir comprar la propiedad no preferida");
    }

    @Test
    public void testImprovementDecision() {
        int cost = 50;
        int cash = 100;
        assertFalse(aggressivePlayer.improvementDecision(tucumanProperty, cost, cash), "Debería decidir no mejorar la propiedad de Tucuman con el dinero insuficiente");
    }




}