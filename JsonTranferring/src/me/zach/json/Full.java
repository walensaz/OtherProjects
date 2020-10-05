package me.zach.json;

import me.zach.json.ItemTransfer.Item;

import java.util.List;

public class Full {

    private List<Inventory> items;

    public Full(List<Inventory> items) {
        this.items = items;
    }

    public List<Inventory> getInventory() {
        return items;
    }

    public void setInventory(List<Inventory> items) {
        this.items = items;
    }


}
