package src.com.Kingdom;

import java.net.*;
import java.io.IOException;

public class Util
{

    //booleans
    public static boolean isNum(String str) {
        boolean bool = true;
        try {
            Double.parseDouble(str);
        }catch (NumberFormatException e) {
            bool = false;
        }
        return bool;
    }

    public static boolean isAge(String age) {
        Boolean bool = false;
        if(isNum(age)) {
            bool = true;
        } 
        return bool;
    }

    public static boolean checkRegister(String email, String age) {
        Boolean bool = false;
        if(email.contains("@") && isAge(age)) {
            bool = true;
        } else {
            System.out.println("Error");
        }
        return bool;
    }   

    public static boolean hasInternet()
    {
        try {
            //make a URL to a known source
            URL url = new URL("http://www.google.com");
            HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();
            Object objData = urlConnect.getContent();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            return false;
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //ints

    //Strings
    
    //void
    public static void SOP(String msg) {
        System.out.println(msg);
    }

    
}
