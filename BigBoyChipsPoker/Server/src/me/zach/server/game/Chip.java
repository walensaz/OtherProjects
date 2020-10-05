package me.zach.server.game;

public enum Chip {
    BLUE(.1, "Blue"),
    WHITE(.25, "White"),
    RED(.5, "Red"),
    BLACK(1, "Black");

    private double value;
    private String name;


    Chip(double value, String name) {
        this.value = value;
        this.name = name;
    }
}
