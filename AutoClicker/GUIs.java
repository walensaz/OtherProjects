import java.awt.Event;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GUIs
{
    public static JFrame frame = new JFrame("AutoClicker");
    private JPanel panel = new JPanel();
    
	private GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	private int width = gd.getDisplayMode().getWidth();
	private int height = gd.getDisplayMode().getHeight();
    
    //Componenets
    private static JButton startbutton = new JButton("Start");
    private static JLabel autoclick = new JLabel("AutoClicker 2.0");
    
    public void createMainGui() {
        //frame
        frame.setSize(width/2,height/2);
        frame.setResizable(true);
        frame.setLocation(width/4, height/4);
        
        
        //JPanel
        panel.setLayout(null);
        panel.setSize(frame.getWidth(), frame.getHeight());
        
        //JMenu -> Different method
        createJMenu(frame);
        
        //Initialize Components
        
        //startbutton.setBounds((frame.getWidth() / 2), (frame.getHeight()), 100, 25);
        
        
        
        
        //Add components
        panel.add(startbutton);
        
        frame.add(panel);
        
        
        //show frame
        
        frame.addComponentListener(new ComponentAdapter() {
        	public void componentResized(ComponentEvent e) {
        		System.out.println(e);
        		resizeComponents(frame);
        	}
        });
        frame.setVisible(true);
    }
    
    
    public static void createJMenu(JFrame fr) {
    	//Menu Bar
    	JMenuBar jbar = new JMenuBar();
        
    	
    	//Listener -> different class
        JListener l = new JListener();
        
        
        //Exit Menu
        JMenu exitmenu = new JMenu("Exit");
        jbar.add(exitmenu);
        
        
        //Exit Item
        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
        exit.setActionCommand("exit");
        exit.addActionListener(l);
        exitmenu.add(exit);
    	
    	//Options Menu
        JMenu optionsmenu = new JMenu("Options");
        jbar.add(optionsmenu);
    	
        //Start Item
        JMenuItem start = new JMenuItem("Start");
        start.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, Event.CTRL_MASK));
        start.setActionCommand("start");
        start.addActionListener(l);
        optionsmenu.add(start);
        
        //Stop Item
        JMenuItem stop = new JMenuItem("Stop");
        stop.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, Event.CTRL_MASK));
        stop.setActionCommand("stop");
        stop.addActionListener(l);
        optionsmenu.add(stop);
        
        
        
        
        
        //set JMenu to frame
        fr.setJMenuBar(jbar);
    	
    }
    
    public void resizeComponents(JFrame frame) {
    	System.out.println(frame.getHeight());
    	startbutton.setBounds((frame.getWidth() / 2) - 50, (int) (frame.getHeight() / 1.4), 100, 25);
    	frame.revalidate();
    	frame.repaint();
    }
    }

