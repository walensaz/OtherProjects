package me.zach.json.ItemTransfer;

public class Item {

    private String id;
    private String amount;


    public Item(String id, String amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    @Override
    public String   toString() {
        return "{\"Item\":{"
                + "\"id\":\"" + id + "\""
                + ", \"amount\":\"" + amount + "\""
                + "}}";
    }
}
