import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class Tester {

    public static void main(String[] args) {
        try {
            PrintWriter printWriter = new PrintWriter(new File("spawn_configtest.txt"));
            BufferedReader reader = new BufferedReader(new FileReader(new File("spawn_configreal.cfg")));
            String temp;
            String[] token3;
            String str = "";
            while ((temp = reader.readLine()) != null) {
                str = "";
                str = temp.split("spawn ")[1];
                printWriter.println(token3);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }


    }

}
