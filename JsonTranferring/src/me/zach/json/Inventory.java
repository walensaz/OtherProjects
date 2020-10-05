package me.zach.json;

import me.zach.json.ItemTransfer.Item;

import java.util.Arrays;
import java.util.List;

public class Inventory {

    private int id;
    private int amount;

    public Inventory(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
