package sample;

public class Tester {
    public static void main(String[] args) {
        /*NumArray numArray = new NumArray(100000);
        numArray.fillArray();
        numArray.listArray();
        System.out.println("---------------");
        numArray.Sort();
        System.out.println("First Array:");
        numArray.listArray();*/

        /*NumArray numArray = new NumArray(100000000);
        numArray.fillArray();
        System.out.println("" +
                "\nSplitting Array!!!!");
        numArray.splitArray();
        numArray.mergeSort();
        System.out.println(" ");
        System.out.println("My Array:");

        System.out.println(" ");
        //numArray.printSortTime("Sort");
        numArray.printSortTime("SortAll");*/

        NumArray numArray = new NumArray(50000000);
        numArray.fillArray();

        Sorter sorter = new Sorter(numArray.getAry());
        sorter.sort(numArray.getAry());
        System.out.println(sorter.getTime());

    }

}
