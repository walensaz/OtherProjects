//Zachary Walensa
//create a bank account
import java.util.Random;

public class BankAccount
{
    private String accountNum;
    private double balance;
    
    public BankAccount(String actNum) {
        balance = 0;
        accountNum = actNum;
    }
    
    public BankAccount(String actNum, double bal) {
        balance = bal;
        accountNum = actNum;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount) {
        balance -= amount;
    }
    
    public double getBalance() {
     return balance;   
    }
    
    public String getAccountNum() {
     return accountNum;   
    }
    
    public void addInterest(double rate) {
        //double interest = 1 + rate;
        balance = balance + balance * rate;
    }

}
