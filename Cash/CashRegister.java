//Zachary Walensa
//Cash Register


public class CashRegister
{
    public static final double QUARTER_VALUE = 0.25;
    public static final double DIME_VALUE = 0.10;
    public static final double NICKLE_VALUE = 0.05;
    public static final double PENNY_VALUE = 0.01;
    
    private double purchase;
    private double payment;
    
    public CashRegister() {
        
        purchase = 0;
        payment = 0;
    
    }
    
    public void recordPurchase(double amount) {
        purchase += amount;
        
        
    }
    
    public void receivePayment(int dollars, int quarters, int dimes, int nickles, int pennies) {
        payment = dollars + quarters * QUARTER_VALUE + dimes * DIME_VALUE + nickles
        * NICKLE_VALUE + pennies * PENNY_VALUE;
        
    }
    
    public double giveChange() {
        double change = payment - purchase;
        purchase = 0;
        payment = 0;
        return change;
        
    }
    
    public void enterDollars(int amount) {
        payment += amount;
    }
    
    public void enterQuarters(int amount) {
        payment += amount * QUARTER_VALUE;
    }
    
    
    
    
}
