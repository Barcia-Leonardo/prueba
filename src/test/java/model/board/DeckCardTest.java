package model.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.cardInterface;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeckCardTest {

    private DeckCard deckCard;
    private List<cardInterface> cards;

//    @BeforeEach
//    public void setUp() {
//
//        // Crear una lista de cartas simuladas para el mazo
//        cards = new ArrayList<>(Destination.crearListaDestino());
//
//        // Crear una instancia de DeckCard con las cartas simuladas
//        deckCard = new DeckCard(cards);
//    }

    @Test
    public void testDeckCard() {

        assertNotNull(deckCard);
    }

    @Test
    public void testGetStackCards() {
        Deque<cardInterface> stackCards = deckCard.getStackCards();
        assertNotNull(stackCards);
        assertEquals(cards.size(), stackCards.size());
        assertTrue(stackCards.containsAll(cards));
    }

    @Test
    public void testTakeOutCard() {



        cardInterface card = deckCard.takeOutCard();
        assertNotNull(card);
        assertTrue(cards.contains(card));
        assertFalse(deckCard.getStackCards().contains(card));
    }

    @Test
    public void testShuffleCards() {


        List<cardInterface> originalCards = new ArrayList<>(cards);
        deckCard.shuffleCards();
        assertNotEquals(originalCards, deckCard.getStackCards());
    }
}
