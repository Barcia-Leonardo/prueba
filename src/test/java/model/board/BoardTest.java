package model.board;

import model.support.Zone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;
    private Pawn pawn;
    private ArrayList<Box> boxes;

    @BeforeEach
    public void setUp() {
        pawn = new Pawn();
        pawn.setPosition(0);
        board = new Board();
        boxes = new ArrayList<>();
    }

    //Constructor 1
    @Test
    public void testBoardInitializationDefault() {

        //assertEquals(boxes, board.getBoxes());
        List<Box> boxes = board.getBoxes();
        assertNotNull(boxes);
        assertEquals(42, board.getBoxes().size());
        assertEquals(0, board.getPositionPlayer());
    }

    //Constructor 2
    @Test
    public void testBoardInitializationParameters() {
        board = new Board(boxes, pawn);
        board.createBoxes();

        assertEquals(boxes, board.getBoxes());

        assertEquals(pawn.getPosition(), board.getPositionPlayer());

        assertEquals(boxes.size(), board.getBoxes().size());

    }


    //3
    @Test
    public void testGetBoxes() {
        List<Box> result = board.getBoxes();
        assertNotNull(result);
        assertEquals(42, result.size());
    }

    //4
    @Test
    public void testGetProperty() {

        assertNull(board.getProperty(0));
    }

    //5
    @Test
    public void testGetBox() {
        Box box = board.getBox(0);
        assertNotNull(box);
        assertEquals(TypeBox.EXIT, box.getTypeBox());
    }


    //6
    @Test
    public void testGetPositionPlayer() {
        int position = board.getPositionPlayer();
        assertEquals(0, position);
    }



    //7
  //  @Test
   // public void testMovePlayer() {


    //    board.movePlayer(0);

    //    assertEquals(2, board.getPositionPlayer());

    //}

    //8
    @Test
    public void testCreateBoxes() {

        List<Box> boxes = board.createBoxes();

        assertNotNull(boxes);
        assertEquals(42, boxes.size());

        assertEquals(TypeBox.EXIT, boxes.get(0).getTypeBox());
        assertEquals(TypeBox.PROPERTIE, boxes.get(1).getTypeBox());
        assertEquals(TypeBox.PROPERTIE, boxes.get(2).getTypeBox() );

        Property property = boxes.get(1).getProperty();
        assertNotNull(property);
        assertEquals(Provinces.FORMOSA, property.getProvince());
        assertEquals(Zone.SUR, property.getZone());
        assertEquals(1000, property.getValue());

    }

    @Test
    public void testInicializeProperties(){
        Board board = new Board();
        List<Property> properties = board.getProperties();
        assertNotNull(properties);
        assertEquals(29, properties.size());

        Property propertyFirst = properties.get(0);
        assertEquals(Provinces.FORMOSA, propertyFirst.getProvince());
        assertEquals(Zone.SUR, propertyFirst.getZone());
        assertEquals(1000, propertyFirst.getValue());
        assertEquals(40, propertyFirst.getRentValue());
        assertEquals(TypeProperty.ESCRITURA, propertyFirst.getTypeProperty());
        assertEquals(TypeUpgradePropertyEnum.VACIA, propertyFirst.getTypeUpgradeProperty());

        int size = board.getProperties().size();
        Property propertyLast = properties.get(size - 1);
        assertEquals(Provinces.BUENOSAIRES, propertyLast.getProvince());
        assertEquals(Zone.NORTE, propertyLast.getZone());
        assertEquals(7400, propertyLast.getValue());
        assertEquals(1000, propertyLast.getRentValue());
        assertEquals(TypeProperty.ESCRITURA, propertyLast.getTypeProperty());
        assertEquals(TypeUpgradePropertyEnum.VACIA, propertyLast.getTypeUpgradeProperty());
    }
}


