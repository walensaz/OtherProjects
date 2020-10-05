
/**
 * Write a description of class FactoryWorker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FactoryWorker implements Worker
{
    
    private static int id;
    private static double salary;
    
    public FactoryWorker() {
        id = 1;
        salary = 39720.33;
    }
    
    @Override
    public void setId(int fid) {
        id = fid;
    }
    
    @Override
    public void setSalary(double sal) {
        salary = sal;
    }
    
    @Override
    public double getSalary() {
        return salary;
    }
    
    public int getId() {
        return id;
    }
    
}
