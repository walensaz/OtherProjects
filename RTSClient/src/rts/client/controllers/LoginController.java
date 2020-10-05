package rts.client.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

    private int width = 550, height = 350;

    @FXML
    JFXTextField username;

    @FXML
    JFXPasswordField password;

    @FXML
    AnchorPane stage;

    @FXML
    JFXButton loginbutton;

    @FXML
    Label title;

    @FXML
    HBox extrasBox;

    @FXML
    VBox vbox;

    @FXML
    Hyperlink FPassword, CAccount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ChangeListener<Number> vboxSizeListener = (observable, oldValue, newValue) -> {
            if(stage.getWidth() <= 710) {
                title.setTranslateX(0);
                loginbutton.setTranslateX(0);
                extrasBox.setTranslateX(0);
                username.setStyle("-fx-font-size:15;");
            } else {
                title.setTranslateX((vbox.getWidth() - width) / 2.3);
                loginbutton.setTranslateX((vbox.getWidth() - width) / 2.25);
                extrasBox.setTranslateX((vbox.getWidth() - width) / 2.5);
            }

            if(stage.getHeight() <= 560) {
                title.setTranslateY(0);
                loginbutton.setTranslateY(0);
                extrasBox.setTranslateY(0);
                password.setTranslateY(0);
                username.setTranslateY(0);

                vbox.setStyle("-fx-font-size:15;");
                username.setStyle("-fx-font-size:15;");
                password.setStyle("-fx-font-size:15;");
                title.setStyle("-fx-font-size:27;");
            } else {
                title.setStyle("-fx-font-size:" + (27 + (int)(vbox.getHeight() - height) / 15) + ";");
                username.setTranslateY((vbox.getHeight() - height) / 3.6);
                username.setStyle("-fx-font-size:" + (15 + (int)(vbox.getHeight() - height) / 20) + ";");
                password.setTranslateY((vbox.getHeight() - height) / 2);
                password.setStyle("-fx-font-size:" + (15 + (int)(vbox.getHeight() - height) / 20) + ";");
                FPassword.setStyle("-fx-font-size:" + (10 + (int)(vbox.getHeight() - height) / 26) + ";");
                CAccount.setStyle("-fx-font-size:" + (10 + (int)(vbox.getHeight() - height) / 26) + ";");
                vbox.setStyle("-fx-font-size:" + (15 + (int)(vbox.getHeight() - height) / 20) + ";");
                loginbutton.setTranslateY((vbox.getHeight() - height) / 2);
                extrasBox.setTranslateY((vbox.getHeight() - height) / 2);
            }
        };

        vbox.widthProperty().addListener(vboxSizeListener);
        vbox.heightProperty().addListener(vboxSizeListener);

        ChangeListener<Number> anchorSizeListener = (observable, oldValue, newValue) -> {
            if(stage.getWidth() <= 710) {
                AnchorPane.setRightAnchor(vbox, 75.0);
                AnchorPane.setLeftAnchor(vbox, 75.0);
                AnchorPane.setTopAnchor(vbox, 75.0);
                AnchorPane.setBottomAnchor(vbox, 75.0);
            } else {
                AnchorPane.setRightAnchor(vbox, (stage.getWidth()/9));
                AnchorPane.setLeftAnchor(vbox, (stage.getWidth()/9));
                AnchorPane.setTopAnchor(vbox, (stage.getHeight()/6.8));
                AnchorPane.setBottomAnchor(vbox, (stage.getHeight()/6.8));
            }
        };

        stage.widthProperty().addListener(anchorSizeListener);
        stage.heightProperty().addListener(anchorSizeListener);
    }
}
