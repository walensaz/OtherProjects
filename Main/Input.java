import java.util.Scanner;

public class Input
{

    public static void main(String[] args) {
        System.out.println("Enter a number to square, cube, and fourth");
        Scanner scanner = new Scanner(System.in);
        Double in = scanner.nextDouble();
        System.out.println(in + " squared is: " + (Math.pow(in, 2)));
        System.out.println(in + " cubed is: " + (Math.pow(in, 3)));
        System.out.println(in + " fourthed is: " + (Math.pow(in, 4)));
    }
    
}
