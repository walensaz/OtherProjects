
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    
    private String name;
    private String schoolName;
    
    public Student(String sname, String school) {
        schoolName = school;
        name = sname;
        
        
    }
    
    public double findCost(double cost) {
        if(schoolName.equalsIgnoreCase("CMH")) {
            cost = cost *0.75;
            
        } else if(schoolName.equalsIgnoreCase("Marquette")) {
            cost = cost * 1.10;
            
        } else {
            cost = cost * 0.90;
            
            
        }
        
        cost = cost*1.05;
        
        return cost;
        
    }
    
    public void displayPets(String pet1, String pet2) {
        if(pet1.compareToIgnoreCase(pet2) < 0) {
            System.out.println(pet1);
            
        } else {
            System.out.println(pet2);   
        }
        
        
    }
    
    
}
