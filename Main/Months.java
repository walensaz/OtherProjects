import java.util.Scanner;

public class Months
{
    
    public static void main(String[] args) {
        int day = 0;
        System.out.println("Enter a month number: ");
        Scanner in = new Scanner(System.in);
        String month;
        String season;
        int num = in.nextInt();
        
        switch(num) {
            case 1:
            case 2:
            case 3:season = "Winter"; break;
            case 4:
            case 5:
            case 6: season = "Spring"; break;
            case 7:
            case 8:
            case 9: season = "Summer"; break;
            case 10:
            case 11:
            case 12: season = "Fall"; break;
            default: season = "Not a season"; break;
        }
        
        switch(num) {
            case 1: day = 31; break;
            case 2: day = 28; break;
            case 3: day = 31; break;
            case 4: day = 30; break;
            case 5: day = 31; break;
            case 6: day = 30; break;
            case 7: day = 31; break;
            case 8: day = 31; break;
            case 9: day = 30; break;
            case 10: day = 31; break;
            case 11: day = 30; break;
            case 12: day = 31; break;
        }
        
        if(num % 3 == 0 && day >= 21) {
            if(season.equalsIgnoreCase("Winter")) {
                season = "Spring";
            } else if(season.equalsIgnoreCase("Spring")) {
                season = "Summer";
            } else if(season.equalsIgnoreCase("Summer")) {
                season = "Fall";
            } else {
                season = "Winter";
            }
        }
        
        
        System.out.println(season);
    }
    
    
}
