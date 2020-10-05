
import java.util.Scanner;
import java.util.Random;

public class Number3
{
    public Number3() {
        int count = 0;
        int amount = 0;
        int average = 1;
        
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        
        while(amount < 100) {
            amount += rand.nextInt(6) + 1;
            amount += rand.nextInt(6) + 1;
            count++;
        }
        System.out.println("It took " + count + " times to reach 100!");
        System.out.println("Type 'next' to get the average of 50 times for 100 amount");
        System.out.println("Otherwise type end!");
        if(in.nextLine().equalsIgnoreCase("next")) {
            System.out.println("Started");
            while(average < 50) {
                amount = 0;
                while(amount < 100) {
                    amount += rand.nextInt(6) + 1;
                    amount += rand.nextInt(6) + 1;
                    count++;
                }
                average++;
            }
            average = count / average;
            System.out.println(average);
        } 
        
        
    }

}
