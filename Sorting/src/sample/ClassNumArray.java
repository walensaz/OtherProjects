package sample;

import java.util.Random;

public class ClassNumArray {
    private int size;
    private int[] ary;
    private long time = 0;
    int location = 0;
    public static int timer = 0;


    public ClassNumArray(int size) {
        this.size = size;
        ary = new int[size];
    }

    public synchronized void addTime() {
        ClassNumArray.timer++;
    }

    public void addValue(int num) {
        ary[location] = num;
        location++;
    }

    public void fillArray() {
        location = 0;
        for (int i = 0;i < ary.length; i++) {
            ary[i] = new Random().nextInt(1500);
            location++;
        }
    }

    public void listArray() {
        for (int k: ary) {
            System.out.print(k + " ");
        }
    }

    public void BubbleSort() {
        long start = System.currentTimeMillis();
        int temp = 0;
        for(int i=0; i < location; i++) {
            for(int k=0; k < location - 1; k++) {
                if (ary[k] > ary[k + 1]) {
                    temp = ary[k];
                    ary[k] = ary[k + 1];
                    ary[k + 1] = temp;
                }
            }
        }
        System.out.println("Sort Completed");
        time = System.currentTimeMillis() - start;
    }


    public void doTheirs() {
        long start = System.currentTimeMillis();
        mergeSort(ary, 0, ary.length - 1);
        time = System.currentTimeMillis() - start;
    }

    public void search(int target) {
        System.out.println(Searches.binarySearch(target, ary));
    }

    private void mergeSort(int[] ary, int i, int j) {
        int mid = 0;
        if(i < j) {
            mid = (i + j) / 2;
            //System.out.println("mid="+mid);
            mergeSort(ary, i, mid);
            mergeSort(ary, mid + 1, j);
            merge(ary, i, mid, j);
        }
    }

    private void merge(int[] arr, int i, int mid, int j) {
        int temp[] = new int[arr.length];
        int l = i;
        int r = j;
        int m = mid + 1;
        int k = l;

        while(l <= mid && m <= r) {
            if(arr[l] <= arr[m]) {
                temp[k++] = arr[l++];
            }
            else {
                temp[k++] = arr[m++];
            }
        }

        while(l <= mid)
            temp[k++] = arr[l++];

        while(m <= r) {
            temp[k++] = arr[m++];
        }

        for(int i1 = i; i1 <= j; i1++) {
            arr[i1] = temp[i1];
        }
    }


    public void insertionSort() {
        long start = System.currentTimeMillis();
        int temp = 0;
        for(int i = 1; i < location; i++) {
            int k = i;
            while(k > 0 && (ary[k] < ary[k - 1])) {
                temp = ary[k];
                ary[k] = ary[k - 1];
                ary[k - 1] = temp;
                k = k - 1;
            }
        }
        time = System.currentTimeMillis() - start;
    }

    public int[] insertionSort(int[] ary) {
        long start = System.currentTimeMillis();
        int temp = 0;
        for(int i = 1; i < ary.length; i++) {
            int k = i;
            while(k > 0 && (ary[k] < ary[k - 1])) {
                temp = ary[k];
                ary[k] = ary[k - 1];
                ary[k - 1] = temp;
                k = k - 1;
            }
        }
        time = System.currentTimeMillis() - start;
        return ary;
    }


    public void selectSort() {
        long start = System.currentTimeMillis();
        int temp = 0;
        int lowele = 0;
        for(int k = 0; k < location; k++) {
            for(int i = k; i < location; i++) {
                if (ary[i] < ary[lowele]) {
                    lowele = i;
                }
            }
            temp = ary[k];
            ary[k] = ary[lowele];
            ary[lowele] = temp;
        }
        time = System.currentTimeMillis() - start;
    }

    public int[] selectSort(int[] ary) {
        long start = System.currentTimeMillis();
        int temp = 0;
        int lowele = 0;
        for(int k = 0; k < ary.length; k++) {
            for(int i = k; i < ary.length; i++) {
                if (ary[i] < ary[lowele]) {
                    lowele = i;
                }
            }
            temp = ary[k];
            ary[k] = ary[lowele];
            ary[lowele] = temp;
        }
        time = System.currentTimeMillis() - start;
        return ary;
    }

    public void mergeSort() {
        long start = System.currentTimeMillis();
        int z = 0;
        int[] tempar1 = new int[size /2];
        int[] tempary2 = new int[size/2];
        int[] temp1 = new int[size/4];
        int [] temp2 = new int[size/4];
        int [] temp3 = new int[size/4];
        int[] temp4 = new int[size/4];

        //int temp1pos = 0;
        //int temp2pos = 0;
        //int temp3pos = 0;
        //int temp4pos = 0;
        //int hold = 0;

        int temp = 0;
        for(int i=0; i < temp1.length; i++) {
            temp1[i] = ary[i];
            temp = i;
        }
        for(int i=0; i < temp2.length; i++) {
            temp2[i] = ary[temp];
            temp++;
        }
        for(int i=0; i < temp3.length; i++) {
            temp3[i] = ary[temp];
            temp++;

        }
        for(int i=0; i < temp4.length; i++) {
            temp4[i] = ary[temp];
            temp++;
        }
        FastSort(temp1);
        FastSort(temp2);
        FastSort(temp3);
        FastSort(temp4);
        try {
            Thread.sleep(150);
        } catch(Exception e) {
            e.printStackTrace();
        }

        /*
        for(int i = 0;i < ary.length; i++) {
            if (temp1[temp1pos] <= temp2[temp2pos] && temp1[temp1pos] <= temp3[temp3pos] && temp1[temp1pos] <= temp4[temp4pos]) {
                hold = temp1[temp1pos];
            } else if (temp2[temp2pos] <= temp1[temp1pos] && temp2[temp2pos] <= temp3[temp3pos] && temp2[temp2pos] <= temp4[temp4pos]) {
                hold = temp2[temp2pos];
            } else if (temp3[temp3pos] <= temp2[temp2pos] && temp3[temp3pos] <= temp1[temp1pos] && temp3[temp3pos] <= temp4[temp4pos]) {
                hold = temp3[temp3pos];
            } else if(temp4[temp4pos] <= temp2[temp2pos] && temp4[temp4pos] <= temp3[temp3pos] && temp4[temp4pos] <= temp1[temp1pos]) {
                hold = temp4[temp4pos];
            }

            if(temp1pos < temp1.length - 1 && temp1[temp1pos] == hold) {
                ary[z] = temp1[temp1pos];
                temp1pos++;
                z++;
            }

            if(temp2pos < temp2.length - 1 && temp2[temp2pos] == hold) {
                ary[z] = temp2[temp2pos];
                temp2pos++;
                z++;
            }

            if(temp3pos < temp3.length - 1 && temp3[temp3pos] == hold) {
                ary[z] = temp3[temp3pos];
                temp3pos++;
                z++;
            }

            if(temp4pos < temp4.length - 1 && temp4[temp4pos] == hold) {
                ary[z] = temp4[temp4pos];
                temp4pos++;
                z++;
            }


        }*/
        tempar1 = mergeTwo(temp1,temp2);
        tempary2 = mergeTwo(temp3,temp4);
        ary = mergeTwo(tempar1,tempary2);
        time = System.currentTimeMillis() - start;
        System.out.println("SortAll Completed");
    }

    public int[] mergeTwo(int[] a, int[] b) {
        int[] merge = new int[a.length + b.length];
        int p = 0, k = 0, n = 0;
        while (p < a.length && n < b.length)
        {
            if (a[p] < b[n]) {
                merge[k] = a[p];
                p++;
            } else {
                merge[k] = b[n];
                n++;
            }
            k++;
        }

        while(p < a.length) {
            merge[k] = a[p];
            k++;
            p++;
        }

        while(n < b.length) {
            merge[k] = b[n];
            k++;
            n++;
        }
        System.out.println("Merge done!");
        return merge;
    }

    public void FastSort(int[] array) {
        new Thread(new Sorter(array)).start();
    }

    public void FastSort() {
        long start = System.currentTimeMillis();
        new Sorter(ary);
        time = System.currentTimeMillis() - start;
    }

    public void printSortTime(String sortType) {
        System.out.println("That took " + time + " milliseconds to " + sortType);
    }

    private void printArray(int[] array) {
        String string = "";
        for (int i=0; i < array.length; i++) {
            string += array[i] + " ";
        }
        System.out.println(string);
    }

    @Override
    public String toString() {
        String string = "";
        for (int i=0; i < location; i++) {
            string += ary[i] + " ";
        }
        return string;
    }

    public static void toString(int[] ary) {
        String string = "";
        for (int i=0; i < ary.length; i++) {
            string += ary[i] + " ";
        }
        System.out.println(string);
    }

}
