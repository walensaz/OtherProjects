package me.filewindow;

import javafx.stage.DirectoryChooser;
import javafx.stage.Window;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FileWindowAPI {

    public static File[] openLoadFileSystem(String title) {
        FileDialog dialog = new FileDialog((Frame) null, title);
        dialog.setMode(FileDialog.LOAD);
        dialog.setMultipleMode(true);
        dialog.setVisible(true);
        File[] files = dialog.getFiles();
        if(files.length == 0 || files == null) {
            return null;
        }
        return files;
    }

    public static File[] openSaveFileSystem(String title) {
        FileDialog dialog = new FileDialog((Frame) null, title);
        dialog.setMode(FileDialog.LOAD);
        dialog.setMultipleMode(true);
        dialog.setVisible(true);
        File[] files = dialog.getFiles();
        if(files.length == 0 || files == null) {
            return null;
        }
        return files;
    }

    public static DirectoryChooser openLoadDirectory(String title, Window window) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle(title);
        return chooser;
    }

}