package packets;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginbutton;
    @FXML
    private VBox vbox;
    @FXML
    private Label error;

    public void login() {
        try {
            if (ConnectionController.login(username.getText())) {
                try {
                    Main.stage.hide();
                    Parent root = FXMLLoader.load(getClass().getResource("chatroom.fxml"));
                    Main.stage.setTitle("Chatroom++");
                    Main.stage.setScene(new Scene(root, 600, 400));
                    Main.stage.show();
                } catch (Exception e) {
                    error.setText("Couldn't find resource chatroom.fxml");
                }
            } else {
                error.setText("Invalid username or password");
            }
        } catch(Exception e) {
            error.setText("Error connecting.... please try again");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
