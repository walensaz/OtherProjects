package rts.client;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("scenes/login.fxml"));
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 700, 500));
        stage.setMinWidth(700);
        stage.setMinHeight(550);
        Launcher.stage = stage;
        stage.show();
    }


    public static void main(String[] args) {


        launch(args);
    }


}
