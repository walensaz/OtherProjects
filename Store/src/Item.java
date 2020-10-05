public class Item {

    private String name;
    private int id;
    private double price;


    public Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}
