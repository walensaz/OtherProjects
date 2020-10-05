import java.awt.*;
import java.awt.event.InputEvent;

public class Macro {

    private int location;
    private int[][] array;
    private int[] click;
    private int modifier;

    public Macro(int size, int modifier) {
        this.array = new int[size][2];
        this.click = new int[size];
        this.modifier = modifier;
        location = 0;
    }

    public void addCoordinate(int x, int y, int click) {
        array[location][0] = x;
        array[location][1] = y;
        this.click[location] = click;
        location++;
    }

    public void clickDown(int x, int y) {
        try {
            Robot bot = new Robot();
            bot.mouseMove(x, y);
            bot.mousePress(InputEvent.BUTTON2_MASK);
            bot.mouseRelease(InputEvent.BUTTON2_MASK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void startMacro() {
        for(int i= 0; i < location; i++) {
            int x = array[i][0];
            int y = array[i][1];
            if(click[i] == 1) {
                try {
                    Robot bot = new Robot();
                    bot.mouseMove(x, y);
                    bot.mousePress(InputEvent.BUTTON1_MASK);
                    bot.mouseRelease(InputEvent.BUTTON1_MASK);
                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }
            } else if(click[i] == 2) {
                try {
                    Robot bot = new Robot();
                    bot.mouseMove(x, y);
                    bot.mousePress(InputEvent.BUTTON2_MASK);
                    bot.mouseRelease(InputEvent.BUTTON2_MASK);
                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }
            } else if(click[i] == 3) {
                try {
                    Robot bot = new Robot();
                    bot.mouseMove(x, y);
                    bot.mousePress(InputEvent.BUTTON2_MASK);
                    bot.mouseRelease(InputEvent.BUTTON2_MASK);
                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }
                try {
                    Robot bot = new Robot();
                    bot.mouseMove(x + 10, y - modifier);
                    bot.mousePress(InputEvent.BUTTON1_MASK);
                    bot.mouseRelease(InputEvent.BUTTON1_MASK);
                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }


            }
        }

    }





}
