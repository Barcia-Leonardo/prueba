package model.board;

import services.cardInterface;

import java.util.*;

public class DeckCard {

        private Deque<cardInterface> stackCards;

       public Deque<cardInterface> getStackCards() {
          return stackCards;
       }

        public DeckCard(List<? extends cardInterface> cards) {
            this.stackCards = new ArrayDeque<>(cards);
            shuffleCards();
        }

        public void shuffleCards() {
            List<cardInterface> cardList = new ArrayList<>(stackCards);
            Collections.shuffle(cardList);
            stackCards = new ArrayDeque<>(cardList);
        }

        public cardInterface takeOutCard() {
            if (!stackCards.isEmpty()) {
                cardInterface card = stackCards.pop();

                return card;
            }
            return null;
        }

}
