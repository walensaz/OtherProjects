
import java.util.Random;
import java.util.Scanner;

public class Number4
{
    Scanner in = new Scanner(System.in);
    public void guessNumber() {
        int num = new Random().nextInt(100) + 1;
        int guess = 0;
        int count = 0;
        
        System.out.println("Try to guess my number!  From 1 - 100");
        while((guess = Integer.valueOf(in.nextLine())) != num) {
            count++;
            if(guess < num) {
                System.out.println("You guess was to low");

            } else {
            
                System.out.println("Your guess was to high!");

            }
        }
        System.out.println("Type again to play again!");
        System.out.println("It took you " + count + " guesses to guess the number");
    }
    
    
    public Number4() {
        guessNumber();
        if(in.nextLine().equalsIgnoreCase("again")) {
            guessNumber();
            while(in.nextLine().equalsIgnoreCase("again")) {
                guessNumber();
                
            }
        }
    }
}
