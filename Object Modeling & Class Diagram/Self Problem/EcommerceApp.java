import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private int orderId;
    private List<Product> products;

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void showOrder() {
        System.out.println("Order ID: " + orderId);
        double total = 0;
        for (Product p : products) {
            System.out.println(" - " + p.getName() + " ($" + p.getPrice() + ")");
            total += p.getPrice();
        }
        System.out.println("Total: $" + total);
    }
}

class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order o) {
        orders.add(o);
    }

    public void showCustomer() {
        System.out.println("\nCustomer: " + name);
        for (Order o : orders) {
            o.showOrder();
        }
    }
}

public class EcommerceApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int cCount = sc.nextInt();
        sc.nextLine();
        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < cCount; i++) {
            System.out.print("\nEnter customer name: ");
            String cname = sc.nextLine();
            Customer customer = new Customer(cname);
            customers.add(customer);

            System.out.print("Enter number of orders for " + cname + ": ");
            int oCount = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < oCount; j++) {
                System.out.print("Enter order ID: ");
                int oid = sc.nextInt();
                sc.nextLine();
                Order order = new Order(oid);

                System.out.print("Enter number of products in order " + oid + ": ");
                int pCount = sc.nextInt();
                sc.nextLine();

                for (int k = 0; k < pCount; k++) {
                    System.out.print("Enter product name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter product price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    order.addProduct(new Product(pname, price));
                }

                customer.placeOrder(order);
            }
        }

        System.out.println("\n--- E-commerce Platform Data ---");
        for (Customer c : customers) {
            c.showCustomer();
        }

        sc.close();
    }
}
