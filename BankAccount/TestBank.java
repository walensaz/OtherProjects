

public class TestBank
{

    public static void main(String[] args) {
        BankAccount Fred = new BankAccount("492FEI");
        Fred.deposit(1000);
        Fred.addInterest(0.1);
        System.out.println(Fred.getBalance());
        new JF().JF();
        
    }
    
}
