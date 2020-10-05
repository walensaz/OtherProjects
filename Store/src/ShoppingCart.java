public class ShoppingCart {

    private Item[] items;
    private int pos;

    public ShoppingCart(int cartcapacity) {
        items = new Item[cartcapacity];
        pos = 0;
    }

    public void addItem(Item item) {
        items[pos] = item;
        pos++;
    }

    public void removeItem(int id) {
        for(int i =0; i < pos; i++) {
            if(items[i].getId() == id) {
                for(int k = i; k < pos - 1; k++) {
                    items[k] = items[k + 1];
                }
                pos--;
            }
        }
    }

    public int numOfItems() {
        return pos;
    }

    public void displayItems() {
        System.out.println("Cart");
        System.out.println("----------------");
        for(int i =0; i < pos; i++) {
            System.out.println(items[i].getName());
        }
    }

    public void sortCart() {
        items = Sorter.insertionSort(items, pos);
    }

    public boolean isInCart(int id) {
        if(binarySearch(id, items))
            return true;
        else
            return false;
    }

    private boolean binarySearch(int target, Item[] itemArray) {
        int left, right ,loc = -1,middle;
        left = 0;
        right = pos - 1;
        while(left <= right && loc == -1) {
            middle = (left + right)/2;
            if(target < itemArray[middle].getId()) {
                right = middle - 1;
            } else if(target > itemArray[middle].getId()) {
                left = middle + 1;
            } else {
                loc = middle;
            }


        }
        if(loc == -1) {
            return false;
        } else {
            return true;
        }
    }


}
