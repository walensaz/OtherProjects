package src.com.Kingdom;


/**
 * Write a description of class updateThread here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class updateThread extends Thread
{
    private long time = System.currentTimeMillis();
    private long times = System.currentTimeMillis(); 
    private double seconds = 1;
    private long cps = 0;
    private int count = 0;
    
    updateThread() {
        while(true) {
            times = System.currentTimeMillis();
            System.out.println("TIME " + time + " TIMES:" + times);
            System.out.println("SECONDS: " + ((times - time) /1000));
            
        }
        /*while(true) {
            times = System.currentTimeMillis();
            seconds = ((times - time) / 1000);
            System.out.println(seconds);
            count++;
            if(seconds >= 1) {
                test.setCPS(test.getCount() /(long)seconds);
                cps = test.getCount() /(long)seconds;
                test.getLabel().setText(cps + " CPS" + " test worked?");
            }
            
        }*/
    }
    
        
    }
    
    
    
    

