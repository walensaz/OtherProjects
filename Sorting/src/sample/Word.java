package sample;

public class Word {

    private String[] strings;
    private int position = 0;

    public Word(int size) {
        strings = new String[size];
    }

    public void addWordToList(String word) {
        strings[position] = word;
        position++;
    }

    public void BubbleSort() {
        String temp;
        for (int i = 0; i < position; i++) {
            for (int k = 0; k < position - 1; k++) {
                if (strings[k].compareTo(strings[k + 1]) > 0) {
                    temp = strings[k];
                    strings[k] = strings[k + 1];
                    strings[k + 1] = temp;
                }
            }
        }

    }

    public void SelectSort() {
        String temp = "";
        int lowele = 0;
        for (int i = 0; i < position; i++) {
            lowele = i;
            for (int k = i; k < position; k++) {
                if (strings[k].compareToIgnoreCase(strings[lowele]) < 0) {
                    lowele = k;
                }
            }
            temp = strings[i];
            strings[i] = strings[lowele];
            strings[lowele] = temp;
        }
    }

    public void insertionSort() {
        String temp = "";
        for (int i = 1; i < position; i++) {
            int k = i;
            while (k > 0 && strings[k].compareToIgnoreCase(strings[k - 1]) < 0) {
                temp = strings[k];
                strings[k] = strings[k - 1];
                strings[k - 1] = temp;
                k = k - 1;
            }
        }
    }

    public void search(String string) {
        System.out.println(Searches.binarySearch(string, strings, position));
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < position; i++) {
            str += strings[i] + ", ";
        }
        return str;
    }

}
