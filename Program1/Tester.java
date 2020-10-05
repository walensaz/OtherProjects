import java.util.ArrayList;
import java.util.List;


public class Tester
{
    private static int sum(int a, int b) {
     int sum = a + b;
     return sum;
        
    }
    public static List<String> add(String k, List<String> list) {
        list.add(k);
        return list;
        
    }
    
    public static void printArray(List<String> list) {
        if(list.size() >= 2) {
            String all = "";
            for(int i=0; i < list.size();i++) {
                System.out.println(list.get(i));
                
            }
            
        } 
    }
    public static void main(String [] args) {
        System.out.println("Hello World");
        System.out.println(String.valueOf(sum(15, 22)));
        List<String> list = new ArrayList<String>();
        add("Hello", list);
        add("How do you do", list);
        add("Yes", list);
        printArray(list);
        
    }

}
