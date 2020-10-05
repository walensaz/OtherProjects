import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class FileAppender {

    public static void main(String[] args) {
        try {
            PrintWriter printWriter = new PrintWriter(new File("stocklist.txt"));
            BufferedReader reader = new BufferedReader(new FileReader(new File("companylist.csv")));
            String temp;
            while ((temp = reader.readLine()) != null) {
                String[] line = temp.split("\",\"");
                if(line[0].equalsIgnoreCase("Symbol")) {
                    continue;
                }
                printWriter.println(line[0].replace("\"", "") + ", " + line[1] + ", " + line[6]);
                printWriter.flush();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }


    }


}
