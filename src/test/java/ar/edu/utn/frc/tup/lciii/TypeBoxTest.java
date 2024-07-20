package ar.edu.utn.frc.tup.lciii;

import model.board.TypeBox;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TypeBoxTest {

    @Test
    void testTypeBox() {
        assertEquals("Propiedad", TypeBox.PROPERTIE.getTypeBox());
        assertEquals("Destino", TypeBox.DESTINY.getTypeBox());
        assertEquals("Suerte", TypeBox.LUCK.getTypeBox());
        assertEquals("Especial", TypeBox.SPECIAL.getTypeBox());
        assertEquals("Ferrocarril", TypeBox.RAILWAY.getTypeBox());
        assertEquals("Premio", TypeBox.PRIZE.getTypeBox());
        assertEquals("Impuesto", TypeBox.TAX.getTypeBox());
        assertEquals("Libre", TypeBox.FREE.getTypeBox());
        assertEquals("Ir a la cárcel", TypeBox.GOTOPRISON.getTypeBox());
        assertEquals("Salida", TypeBox.EXIT.getTypeBox());

    }

    @Test
    void testViewProperty() {
        TypeBox.PROPERTIE.viewProperty();
        TypeBox.DESTINY.viewProperty();
        TypeBox.LUCK.viewProperty();
        TypeBox.TAX.viewProperty();
        TypeBox.FREE.viewProperty();
        TypeBox.GOTOPRISON.viewProperty();
        TypeBox.EXIT.viewProperty();
    }
    @Test
    public void testViewPropertyOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        try {
            TypeBox.PROPERTIE.viewProperty();
            String output = outContent.toString().trim();
            assertEquals("Esta casilla es una propiedad.", output);
        } finally {
            System.setOut(originalOut);
        }
    }
}
