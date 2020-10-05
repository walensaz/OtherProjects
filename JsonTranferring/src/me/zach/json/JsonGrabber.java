package me.zach.json;

import java.io.*;
import java.util.ArrayList;

public class JsonGrabber {

    private File file;

    public JsonGrabber(File file) {
        this.file = file;
    }

    public String getValue(String searchForObject) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String temp = "";
            while ((temp = reader.readLine()) != null) {
                if (temp.contains("\"" + searchForObject + "\": ")) {
                    String str = temp.split(":")[1].split(",")[0];
                    return str.contains("\"") ? str.split("\"")[1].trim() : str.trim();
                }
            }
        } catch (IOException e) {
            System.out.println("[ERROR] IOException finding the value in " + file.getAbsolutePath() + "!!!!!");
        }
        return null;
    }

    public ArrayList<String> getValueList(String searchForObject) {
        ArrayList<String> strings = new ArrayList<>();
        try {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                System.out.println("[ERROR] File not found at " + file.getAbsolutePath() + "!!!!!");
            }
            String temp = "";
            boolean found = false;
            String string = "";
            while ((temp = reader.readLine()) != null) {
                if (temp.contains("\"" + searchForObject + "\": [")) {
                    found = true;
                } else if (temp.contains("]") && found) {
                    break;
                } else {
                    strings.add(temp.split(",")[0]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strings;
    }

    public ArrayList<String> getObjectArray(String searchForObject) {
        ArrayList<String> strings = new ArrayList<>();
        try {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                System.out.println("[ERROR] File not found at " + file.getAbsolutePath() + "!!!!!");
            }
            String temp = "";
            boolean found = false;
            String string = "";
            while ((temp = reader.readLine()) != null) {
                if (temp.contains("{") && found) {
                    while ((temp = reader.readLine()) != null && !temp.contains("}")) {
                        string += temp.split(":")[1].split(",")[0].trim() + ":";
                    }
                    strings.add(string);
                    string = "";
                } else if (temp.contains("\"" + searchForObject + "\": [")) {
                    found = true;
                } else if (temp.contains("]") && found) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strings;
    }

}