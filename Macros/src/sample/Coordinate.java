package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Coordinate {

    private SimpleStringProperty Pstring = new SimpleStringProperty();
    private SimpleStringProperty Xstring = new SimpleStringProperty();
    private SimpleStringProperty Ystring = new SimpleStringProperty();
    private SimpleStringProperty Cstring = new SimpleStringProperty();


    private int pos;
    private int x;
    private int y;
    private ClickType clickType;


    public Coordinate(int x, int y, ClickType clickType) {
        this.x = x;
        this.y = y;
        this.clickType = clickType;
        this.pos = Macro.getLocation();
        String clicks = ClickType.toString(clickType);
        Ystring.set(String.valueOf(y));
        Xstring.set(String.valueOf(x));
        Cstring.set(clicks);
        Pstring.set(String.valueOf(pos));
    }


    public String getCstring() { return Cstring.get(); }
    public String getXstring() {
        return Xstring.get();
    }
    public String getYstring() {
        return Ystring.get();
    }
    public String getPstring() { return Pstring.get();  }


    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public ClickType getC() { return clickType; }


    public void setX(int x) { this.x = x;}
    public void setY(int y) { this.y = y;}
    public void setC(ClickType clickType) { this.clickType = clickType; }

}
