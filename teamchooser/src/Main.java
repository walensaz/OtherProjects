import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> people = new ArrayList<>(Arrays.asList(
                "Ryan", "Zach", "Hauke", "Jake", "Mitch", "Jason"
        ));
        ArrayList<String> teams = new ArrayList<>();
        Random random = new Random();
        int rand1 = 0;
        int rand2 = 0;
        String temp1;
        String temp2;
        while(people.size() > 1) {
            rand1 = random.nextInt(people.size());
            rand2 = random.nextInt(people.size());
            if(rand1 == rand2) {
                continue;
            }
            temp1 = people.get(rand1);
            temp2 = people.get(rand2);
            teams.add("[" + temp1 + ", " + temp2 + "]");
            people.remove(temp1);
            people.remove(temp2);
        }
        System.out.println(teams);
    }
}
