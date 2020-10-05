package me.zach.server.game;

import java.util.ArrayList;

public class Player {

    private String username;
    private Card[] cards;
    private ArrayList<Chip> chips;
    private boolean hasCashedOut;

    public Player(String username) {
        this.username = username;
        this.cards = new Card[2];
        this.chips = new ArrayList<>();
        this.hasCashedOut = false;
    }
}
