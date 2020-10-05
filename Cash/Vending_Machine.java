
/**
 * Vending Machin3e
 * Zachary Walensa
 */
public class Vending_Machine
{
    
    //initialize variables
    public static final double QUARTER_VALUE = 0.25;
    public static final double DIME_VALUE = 0.10;
    public static final double NICKLE_VALUE = 0.05;
    public static final double PENNY_VALUE = 0.01;
    
    private double purchase;
    private double payment;
    
    //Constructor
    public Vending_Machine() {
        purchase = 0;
        payment = 0;
        
    }
    
    //Mutators
    public void addPurchase(double amount) {
        purchase += amount;
    }
    
    public void enterDollars(int amount) {
        payment += amount;
    }
    
    public void enterQuarters(int amount) {
           payment += amount * QUARTER_VALUE;
    }
    
    public void enterDimes(int amount) {
        payment += amount * DIME_VALUE;
    }
    
    public void enterPennies(int amount) {
        payment += amount * PENNY_VALUE;
    }
    
    public void enterNickles(int amount) {
        payment += amount * NICKLE_VALUE;
    }
    
    //Getters
    public String theChange() {
        String s = "Your change: ";
        double change = payment-purchase;
        int dollars = 0;
        int pennies = 0;
        int dimes= 0;
        int nickles = 0;
        int quarters = 0;
        while(change >= 0.25 && change >= 0) {
            change -= 0.25;
            quarters += 1;
        }
        while(change >= 0.10 && change >= 0) {
            change -= 0.10;
            dimes += 1;
        }
        while(change >= 0.05 && change >= 0) {
            change -= 0.05;
            nickles += 1;
        }
        while(change >= 0.01 && change >= 0) {
            change -= 0.01;
            pennies += 1;
        }
        s += "Quarters: " + quarters + " Dimes: " + dimes + " Nickles: " + nickles + " Pennies:" + pennies;
        
        return s;
    }
    
    public void displayChange() {
        int pennies = (int) (payment-purchase);
        int quarters = pennies/25;
        pennies = pennies % 25;
        int dimes = pennies /10;
        pennies %= 10;
        int nickles = pennies /5;
        pennies = pennies % 5;
        System.out.println("Quarters: " + quarters + " Dimes: " + dimes + " Nickles: " + nickles +
        " Pennies: " + pennies);
        
    }
    
    
    
}
