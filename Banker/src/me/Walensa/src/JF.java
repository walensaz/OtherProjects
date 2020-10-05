package me.Walensa.src;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JF implements ActionListener  {

	
	
	//Other variables
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int width = gd.getDisplayMode().getWidth();
	int height = gd.getDisplayMode().getHeight();
	
	
	
	//Frames
	private static JFrame frame = new JFrame("Bank");
	
	
	
	//Buttons
	JButton loginbutton = new JButton("Login");
	
	
	//TextFields
	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();
	
	
	
	//Labels
	JLabel user = new JLabel("Username: ");
	JLabel pass = new JLabel("Password: ");
	
	
	
	
	
	//Functions
	public void sizeFrame(JFrame frame) {
		frame.setResizable(true);
		frame.setSize(800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(500, 150);
		
		
	}
	
	
	
	
	public void mainGui() {
		//Frame size
		sizeFrame(frame);
		
		//JPanel
		JPanel panel = new JPanel();
		
		
		
		//Panel size
		panel.setBounds(frame.getBounds());
		panel.setLayout(null);
		
		//Buttons, labels, etc size
		username.setBounds((int) (frame.getBounds().getX()/2), 75, 200, 25);
		password.setBounds((int) (frame.getBounds().getX()/2), 125, 200, 25);
		
		user.setBounds((int) (frame.getBounds().getX()/2 - 85),75,100,25);
		pass.setBounds((int) (frame.getBounds().getX()/2 - 85), 125, 100, 25);
		loginbutton.setBounds((int) (frame.getBounds().getX()/2 - 55), 175, 100, 25);
		
		
		
		//Add components to panel and frame
		panel.add(username);
		panel.add(password);
		panel.add(user);
		panel.add(pass);
		panel.add(loginbutton);
		
		frame.add(panel);
		
		//Intialize frame
		frame.setVisible(true);
		
		
		
	}




	
	
	//Button events
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(loginbutton)) {
			
		}
		
	}
	
	
	

}
