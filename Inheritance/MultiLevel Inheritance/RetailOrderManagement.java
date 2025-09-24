class Order {
    String orderId;
    String orderDate;

    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order Placed";
    }

    void displayDetails() {
        System.out.println("Order -> ID: " + orderId + ", Date: " + orderDate + ", Status: " + getOrderStatus());
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order Shipped";
    }

    @Override
    void displayDetails() {
        System.out.println("Order -> ID: " + orderId + ", Date: " + orderDate +
                           ", Tracking No: " + trackingNumber + ", Status: " + getOrderStatus());
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order Delivered";
    }

    @Override
    void displayDetails() {
        System.out.println("Order -> ID: " + orderId + ", Date: " + orderDate +
        ", Tracking No: " + trackingNumber + ", Delivery Date: " + deliveryDate +
        ", Status: " + getOrderStatus());
    }
}

public class RetailOrderManagement {
    public static void main(String[] args) {
        Order order = new Order("O1001", "2025-09-15");
        ShippedOrder shipped = new ShippedOrder("O1002", "2025-09-14", "TRK12345");
        DeliveredOrder delivered = new DeliveredOrder("O1003", "2025-09-13", "TRK67890", "2025-09-16");

        order.displayDetails();
        shipped.displayDetails();
        delivered.displayDetails();
    }
}

