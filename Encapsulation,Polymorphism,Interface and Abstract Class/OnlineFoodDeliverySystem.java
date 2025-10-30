import java.util.*;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }

    public abstract double calculateTotalPrice();
}

interface Discountable {
    double applyDiscount(double total);
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public double applyDiscount(double total) {
        return total * 0.9;
    }

    public String getDiscountDetails() {
        return "10% discount applied on Veg Item.";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 20;
    }

    public double applyDiscount(double total) {
        return total * 0.85;
    }

    public String getDiscountDetails() {
        return "15% discount applied on Non-Veg Item.";
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<FoodItem> orderList = new ArrayList<>();

        System.out.print("Enter number of food items: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Item " + (i + 1));
            System.out.print("Enter Item Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Price: ");
            double price = sc.nextDouble();
            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();
            System.out.print("Enter Type (1=Veg, 2=Non-Veg): ");
            int type = sc.nextInt();
            sc.nextLine();

            if (type == 1) orderList.add(new VegItem(name, price, quantity));
            else if (type == 2) orderList.add(new NonVegItem(name, price, quantity));
        }

        double grandTotal = 0;
        System.out.println("\n=== Order Summary ===");
        for (FoodItem item : orderList) {
            System.out.println(item.getItemDetails());
            double total = item.calculateTotalPrice();
            if (item instanceof Discountable) {
                total = ((Discountable) item).applyDiscount(total);
                System.out.println(((Discountable) item).getDiscountDetails());
            }
            System.out.println("Final Price: " + total);
            
            grandTotal += total;
        }

        System.out.println("Grand Total: " + grandTotal);
        sc.close();
    }
}
