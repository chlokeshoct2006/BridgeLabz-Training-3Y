import java.util.ArrayList;

class CartItems {
    String itemName;
    double price;
    int quantity;

    CartItems(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

 
    double getCost() {
        return price * quantity;
    }
}

class ShoppingCart {
    ArrayList<CartItems> cart = new ArrayList<>();

    void addItem(String name, double price, int qty) {
        cart.add(new CartItems(name, price, qty));
        System.out.println(qty + " x " + name + " added to cart.");
    }
    void removeItem(String name) {
        boolean removed = false;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).itemName.equalsIgnoreCase(name)) {
                cart.remove(i);
                System.out.println(name + " removed from cart.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println(name + " not found in cart.");
        }
    }

  
    void displayTotal() {
        double total = 0;
        System.out.println("----- Cart Details -----");
        for (CartItems item : cart) {
            System.out.println(item.itemName + " - " + item.quantity + " x " + item.price + " = " + item.getCost());
            total += item.getCost();
        }
        System.out.println("Total Cost: " + total);
       
    }
}

public class CarItem {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Laptop", 50000, 1);
        cart.addItem("Headphones", 1500, 2);
        cart.addItem("Mouse", 700, 1);
        cart.displayTotal();
        cart.removeItem("Headphones");
        cart.displayTotal();
        cart.removeItem("Keyboard");
    }
}

