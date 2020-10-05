package sample;

public class SelectSort {

    public int[] selectSort(int[] ary) {
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
        return ary;
    }

    public int[] insertionSort(int[] ary) {
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
        return ary;
    }

    public int[] BubbleSort(int[] ary) {
        int temp = 0;
        for(int i=0; i < ary.length; i++) {
            for (int k = 0; k < ary.length - 1; k++) {
                if (ary[k] > ary[k + 1]) {
                    temp = ary[k];
                    ary[k] = ary[k + 1];
                    ary[k + 1] = temp;
                }
            }
        }
        return ary;
    }


}
