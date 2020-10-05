

public class Employee
{
    //initiate variables
    private double salary;
    private String name;
    
    //Constructor
    public Employee(String employeename, double currentSalary) {
        name = employeename;
        salary = currentSalary;
        
    }
    
    
    //Getter methods
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    //setter methods
    public void raiseSalary(double percent) {
        double newsalary = salary + salary / percent;
        salary = newsalary;
    }
    
    public void raiseSalary1(double percent) {
        double newsalary = salary + salary * percent;
        salary = newsalary;
    }
    

}
