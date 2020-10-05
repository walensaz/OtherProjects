import javax.swing.*;
import java.awt.*;

public class JF {
    private static JFrame frame = new JFrame("Administrator");
    
    private JLabel text = new JLabel("Enter AccountNumber");
    private JTextField account = new JTextField("");
    
    public void JF() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(600,600,200,100);
        text.setBounds(25,50,150,50);
        account.setBounds(180,50,150,25);
        
        panel.add(text);
        panel.add(account);
        frame.add(panel);
        
        frame.setSize(600,600);
        
        frame.setVisible(true);
        
    }

}
