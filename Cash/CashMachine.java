

public class CashMachine extends Machine
{
    protected double amount;
    
    
    public CashMachine() {
        id = 1;
        mname = "Cash";
        amount = 100.10;
        
    }
    
    public double getCash() {
        return amount;
        
        
    }
    
    
}
