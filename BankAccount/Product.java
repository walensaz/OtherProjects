

public class Product
{
    //Initiate variables
    private double itemprice;
    private String itemname;
    
    //Constructor
    public Product(String item, double price) {
        itemprice = price;
        itemname = item;
    }
    
    //getters
    public String getName() {
     return itemname;   
    }
    
    public double getPrice() {
     return itemprice;   
    }
    
    //setters
    public void reducePrice(double price) {
        itemprice -= price;
    }
    
    
    
    
}
