import java.util.Scanner;

public class Input2
{

    public static void main(String[] args) {
        System.out.println("Give 2 numbers");
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        System.out.println("Sum is: " + (num1+num2));
        System.out.println("Product is: " + (num1*num2));
        System.out.println("Difference is: " + (num1-num2));
        System.out.println("average is: " + (num1 + num2) / 2);
        System.out.println("Distance is: " + (Math.abs(num1-num2)));
        System.out.println("Maximum is: " + (Math.max(num1,num2)));
        System.out.println("Minimum is: " + (Math.min(num1,num2)));
        
        
    }
    
    
}
