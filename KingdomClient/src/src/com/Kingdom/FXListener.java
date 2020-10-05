package src.com.Kingdom;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.net.*;
import java.io.IOException;

public class FXListener 
{

    private registerClient register;
    private FXLog fxlog = new FXLog();

    Boolean logged = false;

    public void temp() {
        FXLog.mainScene();
    }

    protected void openRegister() {
        FXLog.registerScene();

    }

    protected void openLogin() {
        FXLog.loginScene();

    }

    protected void login() {
        loginClient login = new loginClient(fxlog.getlogUsername(), fxlog.getlogPassword());
        if(login.success()) {
            System.out.println("Login");
            FXLog.mainScene();
        } else {
            System.out.println("Error");
        }
    }

    protected void register() {
        if(Util.checkRegister(fxlog.getEmail(), fxlog.getAge())) {
            if(Util.hasInternet()) {
                try {
                     register = new registerClient(fxlog.getUsername(), fxlog.getPassword(), fxlog.getEmail(), Integer.valueOf(fxlog.getAge()), fxlog.getCountry());
                } catch(Exception ex) {
                     FXLog.showError(ex.getMessage());
                }
                if(!(register.isRegistered())) {
                     openLogin();
                }
            } else {
                FXLog.showError("No Internet!  Please connect to internet to connect!");
            }
        } else {

        }
    }

    
}
