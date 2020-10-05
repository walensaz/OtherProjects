package me.zach.server.game;

public enum Suit {
    HEARTS(1, "Hearts"),
    SPADES(2, "Spades"),
    DIAMONDS(3, "Diamonds"),
    CLUBS(4, "Clubs");

    private int id;
    private String name;

    Suit(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
