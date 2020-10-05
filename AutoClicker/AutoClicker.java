import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Timer;
import java.util.TimerTask;

public class AutoClicker
{
    static GUIs gui = new GUIs();
    
    public static Timer timer = new Timer();
    
    public static void main(String[] args) {
        gui.createMainGui();
        //new RobotClicker(20,700);
}
    
public static Timer getTimer() {
	    return timer;
	   }
    
}
