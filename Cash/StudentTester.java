
/**
 * Write a description of class StudentTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentTester
{
    
    public static void SOP(String s) {
        System.out.println(s);
        
        
    }
    
    
    public static void main(String[] args) {
        Student s1 = new Student("Mickey","CMH");
        Student s2 = new Student("Sally","Pius");
        Student s3 = new Student("Fred","Marquette");
        Student s4 = new Student("Anna","cmh");
        
        SOP("Price: " + s1.findCost(65.00));
        SOP("Price: " + s1.findCost(159.00));
        SOP("Price: " + s2.findCost(159.00));
        SOP("Price: " + s3.findCost(159.00));
        SOP("Price: " + s4.findCost(159.00));
        
        s1.displayPets("fluffy","Floppy");
        s2.displayPets("fido","Simon");
        s3.displayPets("ruf","fluf");
        
        
    }
    
    
}
