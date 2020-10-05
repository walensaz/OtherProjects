package com.Zach;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Tester
{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
       
        File inputFile = new File("D:\\Java\\Input.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("D:\\Java\\Output.txt");
       
        double total = 0;
       
        while (in.hasNextDouble()) {
            double value = in.nextDouble();
            total = total + value;
        }
       
        out.printf("Total: %8.2f\n", total);
       
        in.close();
        out.close();
       
       
       
    }
}