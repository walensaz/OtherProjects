

public class Employee
{

    String name;
    double hrWage;
    
    
    public Employee(String Name, double wage) {
        
        name = Name;
        hrWage = wage;
        
    }
    
    
    public double getPay(double hrsWorked) {
        double pay;
        if(hrsWorked > 50) {
            pay = (hrsWorked - 50) * hrWage;
            pay += (hrsWorked - 50) * (hrWage/2);
        } else {
            pay = hrsWorked * hrWage;
            
        }
        return pay + (pay * 0.05);
    }
    
    
    public String getName() {
        return name;
    }
    
    
    
    
}
