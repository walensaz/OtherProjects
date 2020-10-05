import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("0.0.0.0", 24468);
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner scanner = new Scanner(System.in);
        writer.println("1:Zach:iscool:false");
        writer.flush();
        while(socket.isConnected()) {
            String temp = "";
            if((temp = reader.readLine()) != null) {
                System.out.println(temp);
            }
            Thread.sleep(10);
        }

    }


}
