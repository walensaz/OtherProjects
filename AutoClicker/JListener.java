import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JListener implements ActionListener
{
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "exit") {
            GUIs.frame.dispose();
            AutoClicker.getTimer().cancel();
        } else if(e.getActionCommand() == "start") {
        	
        	
        	
        } else if(e.getActionCommand() == "stop") {
            AutoClicker.getTimer().cancel();
        }
        
    }
}
