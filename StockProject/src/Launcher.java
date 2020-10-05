import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class Launcher {

    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter(new File("stocklist.txt"));
        String[] symbols = getSymbols();
        Map<String, Stock> stocks = YahooFinance.get(symbols);
        for(Stock stock : stocks.values()) {
            stock.print();
        }
    }

    public static String getSymbolFromString(String str) {
        str.split(",");
        return str.split(",")[0].trim();
    }

    public static String[] getSymbols() {
        ArrayList<String> symbols = new ArrayList<>();
        int index = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("stocklist.txt")));
            String temp;
            while ((temp = reader.readLine()) != null) {
                if(!temp.split(",")[0].equalsIgnoreCase("Symbol")) {
                    symbols.add(temp.split(",")[0].trim());
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        String[] finalsymbols = new String[symbols.size()];
        for(int i = 0;i < symbols.size(); i++) {
            finalsymbols[i] = symbols.get(i);
        }
        return finalsymbols;
    }




}
