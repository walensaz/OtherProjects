
import java.util.Scanner;
import java.util.ArrayList;

public class Number1
{
    public Number1() {
        Scanner in = new Scanner(System.in);
        int stop = -1;
        int count = 0;
        int average = 0;
        System.out.println("Enter numbers, when you want to stop enter -1");
        ArrayList<Integer> numlist = new ArrayList<>();
        String line;
        
        while(!((line = in.nextLine()).contains("-1"))) {
            count++;
            numlist.add(Integer.valueOf(line));
            System.out.println("Added");
        }
        
        for(int i=0; i < numlist.size(); i++) {
            average += numlist.get(i);
            
        }
        average = average/count;
        System.out.println("You added " + count + " numbers");
        System.out.println("The average of these numbers was " + average);
        
    }

}
