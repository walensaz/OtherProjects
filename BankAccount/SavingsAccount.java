

public class SavingsAccount
{
    
    //Variables
    private String actNum;
    private double bal;
    private double inter;
    
    
    
    public SavingsAccount(String actNumber) {
        actNum = actNumber;
        bal = 0;
        inter = .10;
        
    }
    
    public SavingsAccount(String actNumber, double balance, double interest) {
        actNum = actNumber;
        bal = balance;
        inter = interest;
        
    }
    
    public double getBalance() {
     return bal + bal * inter;   
    }
    
    public String getAccountNum() {
     return actNum;   
    }
    
    public double getInterestRate() {
        return inter;
    }
    
    public void setInterestRate(double interest) {
        inter = interest;
    }
    
    public void deposit(double amount) {
     bal += amount;   
    }
    
    public void withdraw(double amount) {
       bal -= amount; 
    }
    
    
     

}
