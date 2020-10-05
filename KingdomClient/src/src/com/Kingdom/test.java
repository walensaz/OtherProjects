package src.com.Kingdom;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Write a description of JavaFX class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test extends Application
{
    // We keep track of the count, and label displaying the count:
    private static int count = 0;
    private int whilecount = 0;
    private static long cps = 0;
    private Label myLabel = new Label("0");
    private static Label label;
    
    private boolean clicks = false;

    @Override
    public void start(Stage stage) throws Exception
    {
        // Create a Button or any control item
        Button myButton = new Button("Count");

        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 300);
        pane.setVgap(10);
        pane.setHgap(10);

        //set an action on the button using method reference
        myButton.setOnAction(this::buttonClick);
        label = new Label(cps + " CPS");
        // Add the button and label into the pane
        pane.add(myLabel, 1, 0);
        pane.add(myButton, 0, 0);
        pane.add(label,1,1);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 300,100);
        stage.setTitle("JavaFX Example");
        stage.setScene(scene);

        // Show the Stage (window)
        
        stage.show();
        Thread.sleep(5);
        
        System.out.println("Thread stopped");
        new Thread(new updateThread()).start();
        System.out.println("Thread stopped");
    }
    

    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    private void buttonClick(ActionEvent event)
    {
        // Counts number of button clicks and shows the result on a label
        count = count + 1;
        myLabel.setText(Integer.toString(count));
        clicks = true;
        
    }
    
    public static Label getLabel() {
        return label;
    }
    
    public static long getCPS() {
        return cps;
    }
    
    public static void setCPS(long cps) {
        test.cps = cps;
    }
    
    public static int getCount() {
        return count;
    }
}
