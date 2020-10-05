package me.zach.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import me.zach.json.ItemTransfer.Item;

import javax.xml.validation.TypeInfoProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
       /* //JsonReader jsonReader = new JsonReader(new FileReader(new File("C:\\Users\\Zachary\\AppData\\Local\\Temp\\Convict.json")));
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Zachary\\AppData\\Local\\Temp\\Convict.json")));
        JsonGrabber jsonGrabber = new JsonGrabber(new File("C:\\Users\\Zachary\\AppData\\Local\\Temp\\Convict.json"));
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<String> list = jsonGrabber.getObjectArray("bank");
        for(String str : list) {
            String[] string = str.split(":");
            items.add(new Item(string[0], string[1]));
        }
        System.out.println(jsonGrabber.getValue("donation-credits"));
        System.out.println(jsonGrabber.getValue("username"));
        System.out.println(items);*/

    }

}
