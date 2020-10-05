
/**
 * Write a description of class Testing here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Testing
{
    
    public static void SOP(Object s) {
        System.out.println("" + s);
        
    }
    
    
    public static void main(String[] args) {
        CashMachine machine = new CashMachine();
        SOP("" + machine.getMachineType() + " Amount: " + machine.getCash()
        + " Machine");
        
        FactoryWorker worker = new FactoryWorker();
        
        SOP(worker.getId());
        SOP(worker.getSalary());
        worker.setId(100);
        worker.setSalary(120095.30);
        SOP(worker.getId());
        SOP(worker.getSalary());
    }
    
    
    
    
    
}
