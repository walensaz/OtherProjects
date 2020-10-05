package zach.main;

public class Main {

    public static void main(String[] args) {
        System.loadLibrary("CPPWrapper");
        CPPWrapper wrapper = new CPPWrapper();
        boolean wrapped = wrapper.isKeyPressed();
        while(!wrapper.isKeyPressed()) { }
        System.out.println(wrapped);
    }

}
