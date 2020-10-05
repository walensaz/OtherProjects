

public class BankAccount
{
    
    private double balance = 0;
    private double rate= 0;
    private int numYr= 0;
    
    public BankAccount(double balance, double rate) {
        this.balance = balance;
        this.rate = rate;
        
    }
    
    
    public void findYears(double targetBalance) {
        
        while(balance < targetBalance) {
            numYr++;
            balance = balance * rate + balance;
        }
        
    }
    
    public int getNumYears() {
        return numYr;
    }
    
}
