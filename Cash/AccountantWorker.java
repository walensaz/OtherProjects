

public class AccountantWorker implements Worker
{
    
    private static double salary = 0;
    private static int id = 0;
    
    public AccountantWorker() {
        salary = 40000.00;
        id = 3;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public int getId() {
        return id;
    }
    
    
    
    
}
