import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(50);
        Scanner input = new Scanner(System.in);
        int id;
        String name;
        double price;
        int in = 0;
        while (in != 6) {
            System.out.println("1. Add to cart");
            System.out.println("2. Remove item in cart");
            System.out.println("3. Display items in cart");
            System.out.println("4. Search for item in cart");
            System.out.println("5. Sort cart based on ids");
            System.out.println("6. Quit");
            in = input.nextInt();
            switch (in) {
                case 1:
                    System.out.println("Enter ID: ");
                    id = input.nextInt();
                    System.out.println("Enter name: ");
                    name = input.next();
                    System.out.println("Enter price");
                    price = input.nextDouble();
                    cart.addItem(new Item(id, name, price));
                    break;
                case 2:
                    System.out.println("Enter ID: ");
                    id = input.nextInt();
                    cart.removeItem(id);
                    break;
                case 3:
                    System.out.println("Number of items in cart are " + cart.numOfItems());
                    cart.displayItems();
                    break;
                case 4:
                    System.out.println("Enter ID: ");
                    id = input.nextInt();
                    if (cart.isInCart(id))
                        System.out.println("This item is in your cart");
                    else
                        System.out.println("This item is not in your cart");
                    break;
                case 5:
                    cart.sortCart();
                    System.out.println("Sorted");
                    break;
            }
        }
    }
}





