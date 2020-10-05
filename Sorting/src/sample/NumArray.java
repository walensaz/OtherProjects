package sample;

import java.util.Random;

public class NumArray {
    private int size;
    private int[] ary;
    private int[] temp1;
    private int[] temp2;
    private int[] temp3;
    private int[] temp4;
    private long time = 0;
    private long start = 0;


    public NumArray(int size) {
        this.size = size;
        ary = new int[size];
    }


    public int[] getAry() {
        return ary;
    }


    public void fillArray() {
        for (int i = 0;i < ary.length; i++) {
            ary[i] = new Random().nextInt(1500);
        }
    }

    public void listArray() {
        for (int k: ary) {
            System.out.print(k + " ");
        }
    }

    public void listArrays() {
        System.out.println(" ");
        System.out.println("Array 1: ");
        for(int k: temp1) {
            System.out.print(k+ " ");

        }
        System.out.println(" ");
        System.out.println("Array 2: ");
        for(int n: temp2) {

            System.out.print(n + " ");

        }
        System.out.println(" ");
        System.out.println("Array 3: ");
        for(int k: temp3) {
            System.out.print(k+ " ");

        }
        System.out.println(" ");
        System.out.println("Array 4: ");
        for(int n: temp4) {

            System.out.print(n + " ");

        }

    }

    public void mergeSort() {
        long start = System.currentTimeMillis();
        int temp = 0;
        int loc = 0;
        int z = 0;
        temp1 = new int[size/4 + 1];
        temp2 = new int[size/4 + 1];
        temp3 = new int[size/4 + 1];
        temp4 = new int[size/4 + 1];

        int temp1pos = 0;
        int temp2pos = 0;
        int temp3pos = 0;
        int temp4pos = 0;

        int times = 0;

        int hold = 0;
        int hold2 = 0;

        int count = 0;

        for(int i=0; i < temp1.length; i++) {
            for(int k=0; k < temp1.length - 1; k++) {
                if (temp1[k] > temp1[k + 1]) {
                    temp = temp1[k];
                    temp1[k] = temp1[k + 1];
                    temp1[k + 1] = temp;
                }
            }
        }
        for(int i=0; i < temp2.length; i++) {
            for(int k=0; k < temp2.length - 1; k++) {
                if (temp2[k] > temp2[k + 1]) {
                    temp = temp2[k];
                    temp2[k] = temp2[k + 1];
                    temp2[k + 1] = temp;
                }
            }
        }
        for(int i=0; i < temp3.length; i++) {
            for(int k=0; k < temp3.length - 1; k++) {
                if (temp3[k] > temp3[k + 1]) {
                    temp = temp3[k];
                    temp3[k] = temp3[k + 1];
                    temp3[k + 1] = temp;
                }
            }
        }
        for(int i=0; i < temp4.length; i++) {
            for(int k=0; k < temp4.length - 1; k++) {
                if (temp4[k] > temp4[k + 1]) {
                    temp = temp4[k];
                    temp4[k] = temp4[k + 1];
                    temp4[k + 1] = temp;
                }
            }
        }
        for(int i = 0;i < ary.length; i++) {

            if (temp1[temp1pos] <= temp2[temp2pos] && temp1[temp1pos] <= temp3[temp3pos] && temp1[temp1pos] <= temp4[temp4pos]) {
                hold2 = temp1[temp1pos];
            } else

            if (temp2[temp2pos] <= temp1[temp1pos] && temp2[temp2pos] <= temp3[temp3pos] && temp2[temp2pos] <= temp4[temp4pos]) {
                hold2 = temp2[temp2pos];
            } else

            if (temp3[temp3pos] <= temp2[temp2pos] && temp3[temp3pos] <= temp1[temp1pos] && temp3[temp3pos] <= temp4[temp4pos]) {
                hold2 = temp3[temp3pos];
            } else

            if(temp4[temp4pos] <= temp2[temp2pos] && temp4[temp4pos] <= temp3[temp3pos] && temp4[temp4pos] <= temp1[temp1pos]) {
                hold2 = temp4[temp4pos];
            }

            if(temp1pos < temp1.length - 1 && temp1[temp1pos] == hold2) {
                ary[z] = temp1[temp1pos];
                temp1pos++;
                z++;
            }

            if(temp2pos < temp2.length - 1 && temp2[temp2pos] == hold2) {
                ary[z] = temp2[temp2pos];
                temp2pos++;
                z++;
            }

            if(temp3pos < temp3.length - 1 && temp3[temp3pos] == hold2) {
                ary[z] = temp3[temp3pos];
                temp3pos++;
                z++;
            }

            if(temp4pos < temp4.length - 1 && temp4[temp4pos] == hold2) {
                ary[z] = temp4[temp4pos];
                temp4pos++;
                z++;
            }


        }
        time = System.currentTimeMillis() - start;
        System.out.println("SortAll Completed: " + time);

    }

    public void sortTwo() {
        long start = System.currentTimeMillis();
        int temp = 0;
        int loc = 0;

        int hold = 0;
        int hold2 = 0;

        int count = 0;

        for(int i=0; i < temp1.length; i++) {
            for(int k=0; k < temp1.length - 1; k++) {
                if (temp1[k] > temp1[k + 1]) {
                    temp = temp1[k];
                    temp1[k] = temp1[k + 1];
                    temp1[k + 1] = temp;
                }
            }
        }
        for(int i=0; i < temp2.length; i++) {
            for(int k=0; k < temp2.length - 1; k++) {
                if (temp2[k] > temp2[k + 1]) {
                    temp = temp2[k];
                    temp2[k] = temp2[k + 1];
                    temp2[k + 1] = temp;
                }
            }
        }

        for(int i = 0;i < temp1.length; i = i + 2) {
            if (temp1[i] > temp2[i]) {
                hold = temp1[i];

            } else if (temp2[i] > temp1[i]) {
                hold = temp2[i];
            }
            if((hold >= temp1[i] && hold <= temp2[i]) && (hold >= temp1[i + 1] && hold <= temp2[i])) {
                ary[i] = temp2[i];
                ary[i + 1] = temp2[i];
            } else if((hold <= temp1[i] && hold >= temp2[i]) && (hold <= temp1[i + 1] && hold >= temp2[i])) {
                ary[i] = temp1[i];
                ary[i + 1] = temp1[i];
            } else {
                if (temp1[i] == temp2[i]) {
                    ary[i] = temp1[i];
                    ary[i + 1] = temp2[i];
                } else if (temp1[i] > temp2[i]) {
                    hold = temp1[i];
                    ary[i] = temp2[i];
                    ary[i + 1] = temp1[i];
                    count++;

                } else if (temp2[i] > temp1[i]) {
                    hold = temp2[i];
                    ary[i] = temp2[i];
                    ary[i + 1] = temp1[i];
                    count++;
                }
            }

        }
        time = System.currentTimeMillis() - start;
        System.out.println("SortAll Completed with " + time);

    }

    public void splitArray() {
        int temp = 0;
        for(int i=0; i < (int) ary.length /4; i++) {
            temp1[i] = ary[i];
            temp = i;
        }
        for(int i=0; i < ary.length/4; i++) {
            temp2[i] = ary[temp];
            temp++;
        }
        for(int i=0; i < ary.length/4; i++) {
            temp3[i] = ary[temp];
            temp++;

        }
        for(int i=0; i < ary.length/4; i++) {
            temp4[i] = ary[temp];
            temp++;
        }

    }

    public int[] BubbleSort() {
        long start = System.currentTimeMillis();
        int temp = 0;
        int loc = 0;
        for(int i=0; i < ary.length; i++) {
            for(int k=0; k < ary.length - 1; k++) {
                if (ary[k] > ary[k + 1]) {
                    temp = ary[k];
                    ary[k] = ary[k + 1];
                    ary[k + 1] = temp;
                }
            }
        }
        System.out.println("Sort Completed");
        time = System.currentTimeMillis() - start;
        return ary;
    }

    public void selectSort() {
        int temp = 0;
        int low = 0;
        int lowele = 0;
        for(int k = 0; k < ary.length; k++) {
            for(int i = 0; i < ary.length; i++) {
                if (ary[i] < ary[lowele]) {
                    lowele = i;
                }
            }
            temp = ary[k];
            ary[k] = ary[lowele];
            ary[lowele] = temp;
        }
    }






    public void printSortTime(String sortType) {
        System.out.println("That took " + time + " milliseconds to " + sortType);

    }

}
