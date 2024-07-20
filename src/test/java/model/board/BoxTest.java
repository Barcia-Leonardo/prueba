package model.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BoxTest {
    private Box box;
    private Property property;
    private ArrayList<Pawn> pawns;

    @BeforeEach
    public void setUp() {
        property = new Property();
        pawns = new ArrayList<>();
        box = new Box(TypeBox.PROPERTIE, property, pawns);
    }

    //constructor 1
    @Test
    public void testBoxInitialization() {
        assertEquals(TypeBox.PROPERTIE, box.getTypeBox());
        assertEquals(property, box.getProperty());
        assertEquals(pawns, box.getPawns());
    }




    //3
    @Test
    public void testGetPawns() {
        pawns = box.getPawns();
        assertEquals(pawns, box.getPawns());

    }

    //4
    @Test
    public void testGetTypeBox() {
        assertEquals(TypeBox.PROPERTIE, box.getTypeBox());
        assertNotEquals(TypeBox.TAX, box.getProperty());

    }
    //5
    @Test
    public void testGetProperty() {


        assertEquals(property, box.getProperty());


    }


    //6
    @Test
    public void testSetProperty() {
        Property newProperty = new Property();
        box.setProperty(newProperty);
        assertEquals(newProperty, box.getProperty());
    }


}
