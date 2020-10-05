import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BankAccount
{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        
        File inputFile = new File("C:\\Users\\walensaz\\Documents\\Input.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("C:\\Users\\walensaz\\Documents\\Output.txt");
        
        double total = 0;
        
        while (in.hasNextDouble()) {
            double value = in.nextDouble();
            total = total + value;
        }
        
        out.printf("Total: %8.2f%n", total);
        
        in.close();
        out.close();
        
        
        
    }

}
