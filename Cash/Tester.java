import java.util.Scanner;

public class Tester
{
    public static void SOP(String st) {
        System.out.println(st);
    }

    public static void main(String[] args) {
    
        Scanner in = new Scanner(System.in);
    
        System.out.println("Enter three numbers: ");
    
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int num3 = in.nextInt();
    
          if(num1 < num2 && num2 < num3) {
          System.out.println(num1 + " " + num2 + " " + num3 + "   In order");
        } else if(num1 > num2 && num2 > num3) { 
          System.out.println(num1 + " " + num2 + " " + num3 + "   In order");
        
        } else {
            System.out.println(num1 + " " + num2 + " " + num3 + " : Not in order");
    
          }
          
          
    }
    
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your bowling score: ");
        
        int num = in.nextInt();
        
        if(num >= 250 && num <= 300) {
            System.out.println("become a teacher");
        } else if(num >= 150 && num < 250) {
            System.out.println("Join a league");
        } else {
         System.out.println("Take lessons");   
         
        }
        
    }

    public static void main3(String[] args) {
        Employee emp1 = new Employee("Jane", 21.50);
        Employee emp2 = new Employee("Tom", 35);
        Employee emp3 = new Employee("Fred", 17.50);
        
        SOP("Worked for " + emp1.getPay(39));
        SOP("Worked for " + emp1.getPay(48));
        SOP("Worked for " + emp2.getPay(25));
        SOP("Worked for " + emp2.getPay(48));
        SOP("Worked for " + emp3.getPay(60));
        SOP("Worked for " + emp3.getPay(50));
        
        String s2 = "No";
        String s3 = new String("No");
        
        if(s2.equalsIgnoreCase(s3)) {
            SOP("Same");
        } else {
         SOP("Nope");   
        }
    }

}
