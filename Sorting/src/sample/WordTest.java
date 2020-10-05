package sample;

import java.util.Scanner;

public class WordTest {

    public static void main(String[] args) {
        Word word = new Word(20);
        Scanner input = new Scanner(System.in);
        int in = 0;
        String str;
        while(in != 7) {
            System.out.println("1. Add word to list");
            System.out.println("2. Display List");
            System.out.println("3. Display sorted list");
            System.out.println("4. Select sort");
            System.out.println("5. Insertion sort");
            System.out.println("6. Search.");
            in = input.nextInt();
            switch(in) {
                case 1:
                    System.out.println("Enter Word: ");
                    str = input.next();
                    word.addWordToList(str);
                    break;
                case 2:
                    System.out.println(word.toString());
                    break;
                case 3:
                    word.BubbleSort();
                    System.out.println(word.toString());
                    break;
                case 4:
                    word.SelectSort();
                    System.out.println(word.toString());
                    break;
                case 5:
                    word.insertionSort();
                    System.out.println(word.toString());
                    break;
                case 6:
                    System.out.println("Enter string to search for: ");
                    str = input.next();
                    word.search(str);
                    break;
            }
        }
    }
}
