
public class Tester2
{
   public static void main(String[] args) {
      String wd = "Mississippi";
      String wdt = wd.replaceAll("i","!");
      wd = wd.replaceAll("s","\\$");
      
      System.out.println(wdt);
      System.out.println(wd);
    }
}
