
/**
 * Write a description of class Machine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Machine
{
    
    protected static String mname;
    protected static int id;
    
    public Machine(String machine, int num) {
        mname = machine;
        id = num;
    }
    
    public Machine() {
     id = 0;  
     mname = "Machine";   
    }
    
    public void setMachine(String name) {
     mname = name;   
    }
    
    public void setId(int num) {
     id = num;   
    }
    
    public String getMachineType() {
        return mname;
    }
    
}
