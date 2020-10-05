import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Timer;
import java.util.TimerTask;

public class Clicerk
{

    
    
        public static boolean run = false;
    private static int times;
    private static int num;
    
    Timer timer = new Timer();
    
        //Amount of clicks clicker
    public void RobotClicker(int clicktimes, int timeinms) {
    	
    	num = 0;
    	times = clicktimes;
    	
    	timer.scheduleAtFixedRate(new TimerTask() {
        	@Override
        	public void run() {
        		try {
        			Robot bot = new Robot();
        			//bot.mouseMove(x, y);    
        			bot.mousePress(InputEvent.BUTTON1_MASK);
        	bot.mouseRelease(InputEvent.BUTTON1_MASK);
        		} catch(Exception e) {
        			System.out.println(e);
        		}
        		num++;
        		if(num >= times) {
        			timer.cancel();
        		}
      
        	}
        }, timeinms, timeinms);
    	
    }
    
    
    
}
