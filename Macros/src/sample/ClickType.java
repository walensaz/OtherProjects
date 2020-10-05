package sample;

public class ClickType {
    public final static ClickType LEFT_CLICK_DOWN = new ClickType(0);
    public final static ClickType LEFT_CLICK_UP = new ClickType(1);
    public final static ClickType RIGHT_CLICK_DOWN = new ClickType(2);
    public final static ClickType RIGHT_CLICK_UP = new ClickType(3);
    public final static ClickType SPECIAL_CLICK = new ClickType(4);
    public final static ClickType LEFT_CLICK = new ClickType(5);
    public final static ClickType RIGHT_CLICK = new ClickType(6);

    public static ClickType parseClick(String s) {
        if(s.equalsIgnoreCase("Left Click")) {
            return ClickType.LEFT_CLICK;
        } else if(s.equalsIgnoreCase("Right Click")) {
            return ClickType.RIGHT_CLICK;
        } else {
            return ClickType.SPECIAL_CLICK;
        }
    }


    public static String toString(ClickType clickType) {
        if(clickType == ClickType.LEFT_CLICK) {
            return "Left Click";
        } else if(clickType == ClickType.RIGHT_CLICK) {
            return "Right Click";
        } else {
            return "Special Click";
        }
    }

    private int click;
    private ClickType(int click) {
        this.click = click;
    }
}
