package me.zach.server.game;

public class Deck {

    public static int DECK_SIZE = 52;

    private Card[] deckOfCards;

    public Deck() {
        deckOfCards = new Card[DECK_SIZE];
        int incrementer = 0;
        for(CardType cardType : CardType.values()) {
            deckOfCards[incrementer] = new Card(Suit.SPADES, cardType);
            deckOfCards[incrementer + 1] = new Card(Suit.HEARTS, cardType);
            deckOfCards[incrementer + 2] = new Card(Suit.CLUBS, cardType);
            deckOfCards[incrementer + 3] = new Card(Suit.DIAMONDS, cardType);
            incrementer = incrementer + 4;
        }
    }

    public Card[] getDeckOfCards() {
        return deckOfCards;
    }

    public void shuffle(int times) {
        for(int j = 0; j < times; j++) {
            for (int i = 0; i <= DECK_SIZE; i++) {
                int randomIndexToSwap = (int) (Math.random() * 52) + 1;
                Card currentCard = deckOfCards[i];
                deckOfCards[i] = deckOfCards[randomIndexToSwap];
                deckOfCards[randomIndexToSwap] = currentCard;
            }
        }
    }

    private void moveAllCardsUpAndAddNoCardToEnd() {
        Card prevCard = Card.NO_CARD;
        for(int i = DECK_SIZE; i >= 0; i--) {
            Card newPrevCard = deckOfCards[i];
            deckOfCards[i] = prevCard;
            prevCard = newPrevCard;
        }
    }

    public Card getNextCardInDeckAndUse() {
        Card cardToGive = deckOfCards[0];
        moveAllCardsUpAndAddNoCardToEnd();
        return cardToGive;
    }
}