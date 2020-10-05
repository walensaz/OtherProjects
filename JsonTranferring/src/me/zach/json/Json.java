package me.zach.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Json {

    private File file;

    public Json(File file) {
        if(!file.getName().contains(".json")) {
            return;
        }
        this.file = file;
    }

    public File getFile() {
        return file;
    }

}
