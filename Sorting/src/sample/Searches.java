package sample;

public class Searches {

    public static String binarySearch(int target, int[] intArray) {
        int left,right,loc = -1,middle;
        left = 0;
        right = intArray.length - 1;
        while(left <= right && loc == -1) {
            middle = (left + right)/2;
            if(target < intArray[middle]) {
                right = middle - 1;
            } else if(target > intArray[middle]) {
                left = middle + 1;
            } else {
                loc = middle;
            }


        }
        if(loc == -1) {
            return "Not Found";
        } else {
            return "Found";
        }
    }

    public static String binarySearch(String target, String[] strArray, int pos) {
        int left,right,loc = -1,middle;
        left = 0;
        right = pos - 1;
        while(left <= right && loc == -1) {
            middle = (left + right)/2;
            if(strArray[middle].compareToIgnoreCase(target) > 0) {
                right = middle - 1;
            } else if(strArray[middle].compareToIgnoreCase(target) < 0) {
                left = middle + 1;
            } else {
                loc = middle;
            }
            System.out.println("Through");

        }
        if(loc == -1) {
            return "Not Found";
        } else {
            return "Found";
        }


    }



}
