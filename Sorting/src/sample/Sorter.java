package sample;

public class Sorter implements Runnable{

    private int[] array;
    private long start;
    private long end;

    public Sorter(int[] array) {
        this.array = array;
    }

    public void run() {
        sort(array);
    }


    public void sort(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }
        int length = array.length;
        start = System.currentTimeMillis();
        quickSort(array,0, length - 1);
        end = System.currentTimeMillis();
    }

    public long getTime() {
        return end - start;
    }

    private void quickSort(int[] ary, int low, int high) {

        int lower = low;
        int higher = high;
        int mid = ary[low+(high-low)/2];


        while (lower <= higher) {
            while (ary[lower] < mid) {
                lower++;
            }
            while (ary[higher] > mid) {
                higher--;
            }
            if (lower <= higher) {
                exchangeNumbers(ary, lower, higher);
                //move index to next position on both sides
                lower++;
                higher--;
            }
        }
        // call quickSort() method recursively
        if (low < higher)
            quickSort(ary, low, higher);
        if (lower < high)
            quickSort(ary, lower, high);
    }

    private void exchangeNumbers(int[] ary, int i, int j) {
        int temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }



}
