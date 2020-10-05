package sample;

import java.awt.*;
import java.awt.event.InputEvent;

public class Macro {

    private static int location = 0;
    private Coordinate[] cords;
    private ClickType[] click;
    private int modifier;

    public Macro(int size, int modifier) {
        this.cords = new Coordinate[size];
        this.modifier = modifier;
        location = 0;
    }

    public void addCoordinate(int x, int y, ClickType clickType) {
        cords[location] = new Coordinate(x,y,clickType);
        location++;
    }

    public void clickDown(int x, int y) {
        try {
            Robot bot = new Robot();
            bot.mouseMove(x, y);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }




    public void startMacro() {
        for(int i= 0; i < location; i++) {
            int x = cords[i].getX();
            int y = cords[i].getY();
            if(cords[i].getC() == ClickType.LEFT_CLICK) {
                try {
                    Robot bot = new Robot();
                    bot.mouseMove(x, y);
                    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }
            } else if(cords[i].getC() == ClickType.RIGHT_CLICK) {
                try {
                    Robot bot = new Robot();
                    bot.mouseMove(x, y);
                    bot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
                    bot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }
            } else if(cords[i].getC() == ClickType.SPECIAL_CLICK) {

                try {
                    Robot bot = new Robot();
                    bot.mouseMove(x, y);
                    bot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
                    bot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }


                try {
                    Robot bot = new Robot();
                    bot.mouseMove(x + 10, y - modifier);
                    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }
            }
        }
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public static int getLocation() { return location; }



}
