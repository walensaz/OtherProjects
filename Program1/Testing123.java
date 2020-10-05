import java.util.Scanner;

public class Testing123
{
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    
     System.out.print("Please Enter ammount: ");
    int amount = in.nextInt();
    if(amount >= 4900) {
        System.out.print("Please enter interest rate(decimal): ");
        double interest = in.nextDouble();
        double total = amount * interest;
        System.out.println(total);
        
    } else {
     System.out.println("Not enough money");   
    }
    
    }
}
