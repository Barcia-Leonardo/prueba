package model.board;

import model.support.Zone;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {

    @Test
    void testPropertyInitialization() {
        Property property = new Property(Provinces.BUENOSAIRES, Zone.CENTRO, 5000, 500, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA);
        assertEquals(5000, property.getValue());
        assertEquals(500, property.getRentValue());
        assertEquals(Provinces.BUENOSAIRES, property.getProvince());
        assertEquals(Zone.CENTRO, property.getZone());
        assertFalse(property.isOwned());
    }

    @Test
    void testSetOwned() {
        Property property = new Property();
        property.setOwned(true);
        assertTrue(property.isOwned());
    }

    @Test
    void testViewProperty() {
        Property property = new Property(Provinces.BUENOSAIRES, Zone.CENTRO, 5000, 500, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA);
        String expectedView = "Property: BUENOSAIRES CENTRO | Value: 5000 | Rent: 500 | Description: Propiedad en Buenos Aires, Zona CENTRO | Type Property: Escritura | Mejora: VACIA";
        assertEquals(expectedView, property.viewProperty());
    }

    @Test
    void testUpgradeProperty() {
        Property property = new Property(Provinces.BUENOSAIRES, Zone.CENTRO, 5000, 500, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA);
        TypeUpgradePropertyEnum newUpgrade = TypeUpgradePropertyEnum.DOS_CHACRAS;
        property.upgradeProperty(newUpgrade);
        assertEquals(newUpgrade, property.getTypeUpgradeProperty());
    }

    @Test
    public void TypeUpgradeEnumTest(){
        Property propertyVacia = new Property(Provinces.FORMOSA, Zone.SUR, 1000, 40, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA);
        assertEquals(TypeUpgradePropertyEnum.VACIA, propertyVacia.getTypeUpgradeProperty());
        Property propertyChacra = new Property(Provinces.FORMOSA, Zone.SUR, 1000, 40, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.CHACRA);
        assertEquals(TypeUpgradePropertyEnum.CHACRA, propertyChacra.getTypeUpgradeProperty());
        Property propertyDosChacras = new Property(Provinces.FORMOSA, Zone.SUR, 1000, 40, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.DOS_CHACRAS);
        assertEquals(TypeUpgradePropertyEnum.DOS_CHACRAS, propertyDosChacras.getTypeUpgradeProperty());
        Property propertyEstancia = new Property(Provinces.FORMOSA, Zone.SUR, 1000, 40, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.ESTANCIA);
        assertEquals(TypeUpgradePropertyEnum.ESTANCIA, propertyEstancia.getTypeUpgradeProperty());
    }
}
