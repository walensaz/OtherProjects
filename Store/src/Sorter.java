public class Sorter {

    public static Item[] insertionSort(Item[] ary, int pos) {
        Item temp;
        for(int i = 1; i < pos; i++) {
            int k = i;
            while(k > 0 && (ary[k].getId() < ary[k - 1].getId())) {
                temp = ary[k];
                ary[k] = ary[k - 1];
                ary[k - 1] = temp;
                k = k - 1;
            }
        }
        return ary;
    }



}
