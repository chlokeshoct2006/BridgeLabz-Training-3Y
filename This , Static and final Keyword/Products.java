class Product {
    static double discount = 10.0;

    private String productName;
    private double price;
    private int quantity;
    private final int productID;

    public Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayDetails() {
        if (this instanceof Product) {
            double totalPrice = price * quantity;
            double discountedPrice = totalPrice - (totalPrice * discount / 100);
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Price: " + totalPrice);
            System.out.println("Discounted Price: " + discountedPrice);
        }
    }
}

public class Products {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 50000, 1, 101);
        Product p2 = new Product("Mobile", 20000, 2, 102);

        p1.displayDetails();
        System.out.println();
        p2.displayDetails();

        Product.updateDiscount(20.0);
        System.out.println("\nAfter updating discount:\n");
        p1.displayDetails();
        System.out.println();
        p2.displayDetails();
    }
}

