

import java.util.Scanner;

public class Number2
{
    public Number2() {
        Scanner in = new Scanner(System.in);
        int max = 0;
        int min = 0;
        int count = 0;
        System.out.println("Enter numbers, when you want to stop enter 0");
        
        
        String line;
        
        while(!((line = in.nextLine()).contains("0"))) {
            count++;
            if(Integer.valueOf(line) > max) {
                max = Integer.valueOf(line);
            } else if(Integer.valueOf(line) < min) {
                min = Integer.valueOf(line);
            }
            System.out.println("Added");
        }

        System.out.println("Max is " + max);
        System.out.println("Min is " + min);
        System.out.println("Loop went through " + count + " times");
    }
    

}
