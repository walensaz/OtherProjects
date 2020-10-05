import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

public class JF implements ActionListener
{
    //Frames
    static JFrame frame = new JFrame("MainBank");
    static JFrame frame2 = new JFrame("Account");
    static JF plugin = new JF();
    
    //Buttons
    JButton Account = new JButton("Account");
    JButton MainPage = new JButton("Main Page");
    JButton CreateAccount = new JButton("Create Account");
    JButton CreateAccount1 = new JButton("Create Account");
    
    //Intialize other variables
    static String name;
    static String age;
    static String DOB;
    
    public static void main(String[] args) {
        new JF().createMainGui();
        
    }
    
    
    
    public void clearGui() {
        frame.setVisible(false);
        frame.getContentPane().removeAll();
    }
    
    
        
    public void createMainGui() {
    //More initialization
    JPanel panel = new JPanel();
    
    //Layout
    panel.setLayout(null);
    Account.setBounds(300,100,150,30);
    CreateAccount.setBounds(300,50,150,30);
    panel.setBounds(800,800,200,100);
    
    //adding panel and making frame
    //JFrame frame = new JFrame("Window");
    panel.add(CreateAccount);
    panel.add(Account);
    frame.add(panel);
   
    //Events
    Account.addActionListener(this);
    CreateAccount.addActionListener(this);
    
    //Setting options for the frame
    frame.setSize(700,700);
    frame.setBackground(Color.WHITE);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    
    frame.setVisible(true);
    }
    
    
    //Action Listener 
    public void actionPerformed(ActionEvent e) {
        //Create Account Button
        if(e.getSource() == CreateAccount) {
            new JF().clearGui();
            new JF().createCreateAccountGui(); 
            
    } else if(e.getSource() == CreateAccount1) {
    
    	
    } else if(e.getSource() == MainPage) {
    	new JF().clearGui();
    	new JF().createMainGui();
    }
    }
    
    
    //Create Account GUI
    public void createCreateAccountGui () {
            //More initialization
    JPanel panel = new JPanel();
    //Layout
    String name1 = JOptionPane.showInputDialog("What is your name?");
    String age1 = JOptionPane.showInputDialog("What is your age?");
    String DOB1 = JOptionPane.showInputDialog("What is Date of Birth?");
    if(name1.isEmpty() || age1.isEmpty() || DOB1.isEmpty()) {
    	JOptionPane.showMessageDialog(null,"Please provide all information warranted.");
    	plugin.clearGui();
    	plugin.createMainGui();
    	
    }
    DOB = DOB1;
    name = name1;
    age = age1;
    panel.setLayout(null);
    CreateAccount1.setBounds(300,50,150,30);
    MainPage.setBounds(300, 150, 150, 30);
    panel.setBounds(800,800,200,100);
    
    //adding panel and making frame
    panel.add(CreateAccount1);
    panel.add(MainPage);
    frame.add(panel);
   
    //Events
    CreateAccount1.addActionListener(this);
    MainPage.addActionListener(this);
    
    //Setting options for the frame
    frame.setSize(700,700);
    frame.setBackground(Color.WHITE);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    
    frame.setVisible(true);
        
        
    }
    
}
