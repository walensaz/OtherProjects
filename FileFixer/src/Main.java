import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class Main {

    public static void main1(String[] args) {
        try {
            PrintWriter printWriter = new PrintWriter(new File("spawn_config1.txt"));
            BufferedReader reader = new BufferedReader(new FileReader(new File("spawn_config.cfg")));
            String temp;
            while ((temp = reader.readLine()) != null) {
                String done = "";
                done = temp.replace("\t", " ").replace("spawn =", "spawn");
                printWriter.println(done);
                printWriter.flush();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        PrintWriter printWriter = new PrintWriter(new File("spawn_configreal.txt"));
        BufferedReader reader = new BufferedReader(new FileReader(new File("spawn_config1.txt")));
        String temp;
        while((temp = reader.readLine()) != null) {
            String print = "";
            if(temp.startsWith("spawn")) {
                String[] strs = temp.split(" ");
                String name = "";
                for(int i = 9; i < strs.length; i++) {
                    name += strs[i] + " ";
                }
                name = name.trim();
                String replace = "";
                for(int i = 0; i < 9; i++) {
                    replace += strs[i] + " ";
                }
                printWriter.println(replace + name.replace(" ", "_"));
                printWriter.flush();
            } else {
                printWriter.println(temp);
                printWriter.flush();
            }
        }

    }


}
