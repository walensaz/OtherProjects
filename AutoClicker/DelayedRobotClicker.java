import java.util.Timer;
import java.util.TimerTask;

public class DelayedRobotClicker
{
    //if id = 1 then run the amount of clicks auto clicker else run the auto clicker
    
    
    //Delayed auto clicker
    Timer timer = AutoClicker.getTimer();
    public DelayedRobotClicker(int delay, int timeinms) {
        
        timer.schedule(new TimerTask() { 
            @Override
            public void run() {
            
            new RobotClicker(timeinms);
            
        }
    },delay);
        
        
    }
    
    public DelayedRobotClicker(int delay, int clicktimes, int timeinms) {
        timer.schedule(new TimerTask() {
            
            public void run() {
                new RobotClicker(clicktimes, timeinms);
            }
        }, delay);
    }
}
