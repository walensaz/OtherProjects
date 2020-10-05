import java.util.Scanner;
import java.math.BigInteger;

public class GradeTest
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter how many test scores your comparing");
        int num = in.nextInt();
        
       System.out.println("Enter " + num + " scores: ");
       
       int total = 0;
       int totalin = 0;
       
       for(int i=0; i < num; i++) {
            int s = in.nextInt();
            totalin += 1;
            total += s;
            in.nextLine();
            System.out.println("You need " + (num - totalin) + " more numbers");
        }
       
       
       BigInteger i = new BigInteger("534534634623534363434434343434334");
       System.out.println("Average: " + (total) / num);
       
        
    }
}
