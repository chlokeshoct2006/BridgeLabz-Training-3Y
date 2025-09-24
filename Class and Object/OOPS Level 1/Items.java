class Item {
    int itemCode;
    String itemName;
    double price;

    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    void displayItemDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
    }

    double calculateTotalCost(int quantity) {
        return price * quantity;
    }
}

public class Items {
    public static void main(String[] args) {
        Item item1 = new Item(101, "Notebook", 50.0);
        Item item2 = new Item(102, "Pen", 10.0);


        System.out.println("Item 1 Details:");
        item1.displayItemDetails();
        System.out.println("Total cost for 5 Notebooks: " + item1.calculateTotalCost(5));

        System.out.println("\nItem 2 Details:");
        item2.displayItemDetails();
        System.out.println("Total cost for 10 Pens: " + item2.calculateTotalCost(10));
    }
}
