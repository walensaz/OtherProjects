
/**
 * Write a description of class ProductPrinter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductPrinter
{

    public static void main(String[] args) {
        Product banana = new Product("banana", 7.75);
        Product orange = new Product("Orange", 9.85);
        System.out.println(orange.getName() + " costs: " + orange.getPrice());
        System.out.println(banana.getName() + " costs: " + banana.getPrice());
        orange.reducePrice(5.1);
        banana.reducePrice(5);
        System.out.println(orange.getName() + " costs: " + orange.getPrice());
        System.out.println(banana.getName() + " costs: " + banana.getPrice());
    }
    
    
}
