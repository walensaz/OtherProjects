package me.zach.server.game;

public class Card {

    public static Card NO_CARD = new Card(null, null);

    private Suit suit;
    private CardType cardType;

    public Card(Suit suit, CardType cardType) {
        this.suit = suit;
        this.cardType = cardType;
    }

    public Suit getSuite() {
        return suit;
    }

    public CardType getCardType() {
        return cardType;
    }
}
