package ar.edu.utn.frc.tup.lciii;

import model.board.TypeCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TypeCardTest {

    @Test
    void testTypeCard() {
        assertEquals("Suerte", TypeCard.LUCK.getTypeCard());
    }
}