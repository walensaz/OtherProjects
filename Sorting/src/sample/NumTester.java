package sample;

import java.util.Scanner;

public class NumTester {
    public static void main(String[] args) {
        ClassNumArray classNumArray = new ClassNumArray(15000);
        Scanner input = new Scanner(System.in);
        int in = 0;
        int value;
        while(in != 9) {
            System.out.println("1. Add number to list");
            System.out.println("2. Display List");
            System.out.println("3. Display SelectSort list");
            System.out.println("4. Display BubbleSort list");
            System.out.println("5. Display MergeSort list");
            System.out.println("6. Display InsertionSort list");
            System.out.println("7. Fill list with random numbers");
            System.out.println("8. Search for number");
            System.out.println("9. Quit");
            in = input.nextInt();
            switch(in) {
                case 1:
                    System.out.println("Enter Number: ");
                    value = input.nextInt();
                    classNumArray.addValue(value);
                    break;
                case 2:
                    System.out.println(classNumArray.toString());
                    break;
                case 3:
                    classNumArray.selectSort();
                    System.out.println(classNumArray.toString());
                    classNumArray.printSortTime("Select");
                    break;
                case 4:
                    classNumArray.doTheirs();
                    System.out.println(classNumArray.toString());
                    classNumArray.printSortTime("TheirMerge");
                    break;
                case 5:
                    classNumArray.mergeSort();
                    System.out.println(classNumArray.toString());
                    classNumArray.printSortTime("MyMerge");
                    //classNumArray.search(45);
                    break;
                case 6:
                    classNumArray.FastSort();
                    //System.out.println(classNumArray.toString());
                    classNumArray.printSortTime("Insertion");
                    break;
                case 7:
                    classNumArray.fillArray();
                    break;
                case 8:
                    System.out.println("Enter Number to search for: ");
                    value = input.nextInt();
                    classNumArray.search(value);
                    break;
                }
            }
        }
    }

