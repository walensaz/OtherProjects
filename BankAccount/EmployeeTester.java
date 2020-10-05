

public class EmployeeTester
{
    public static void main(String[] args) {
        
        //The emplyoee
    Employee employee = new Employee("Coder, Joe", 25000);
    //get employees name
    employee.getName();
    System.out.println(employee.getName() + " salary is: " + employee.getSalary());
    employee.raiseSalary(10);
    System.out.println(employee.getName() + " salary is: " + employee.getSalary());
    
    
    }
}
