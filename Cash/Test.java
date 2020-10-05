import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test implements ActionListener
{
    private static JFrame frame = new JFrame("Frame");
    private static JPanel panel = new JPanel();
    private static JTextField field = new JTextField("Write an equation");
    private static JButton button = new JButton("Calculate");
    private static Test test = new Test();
    
   public static void main(String[] args) {
       frame.setResizable(true);
       frame.setSize(500,500);
       
       panel.setSize(500,500);
       
       field.setSize(50,50);
       button.setSize(50,50);
       button.addActionListener(test);
       
       
       panel.add(field);
       panel.add(button);
       frame.add(panel);
       
       
       frame.setVisible(true);
    
       
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(field.getText().contains("(") || field.getText().contains(")")) {
            int start = field.getText().indexOf("(") + 1;
            int end = field.getText().indexOf(")");
            System.out.println(field.getText().substring(start,end));
        }
        
        
    }
    
}
