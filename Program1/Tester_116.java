
import javax.swing.JOptionPane;

public class Tester_116
{
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("What is your name?");
        JOptionPane.showInputDialog("Hi, My name is Hal! What would you like me to do?");
        JOptionPane.showMessageDialog(null, "Im sorry, " + name + " I can not do that.");
    }
}

