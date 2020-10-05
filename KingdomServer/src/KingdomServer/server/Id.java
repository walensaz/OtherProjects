package KingdomServer.server;

import java.util.Random;

public class Id
{
    
    private static String id = "";

    public Id() {
     for(int i=0; i < 25; i++) {
            Random rand = new Random();
            int num = rand.nextInt(64) + 0;
            char add = (char) 44;
            if(num >= 0 && num <= 27) {
                num = rand.nextInt(25) + 0;
                add = (char)(num + 'a');
                
            } else if(num > 27 && num <= 54) {
                num = rand.nextInt(25) + 0;
                add = (char)(num + 'A');
            } else if(num > 54 && num <= 64) {
                num = rand.nextInt(10) + 0;
                add = (char)(num + '0');
            }
            id += add;
            
        }
        System.out.println(id);   
        
    }
    
    public String getId() {
        return id;
    }
    
}
