public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double totalCost;

    public CarRental() {
        this("Unknown", "Standard", 1);
    }

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        calculateTotalCost();
    }

    void calculateTotalCost() {
        double rate = 50; 
        totalCost = rentalDays * rate;
    }

    void display() {
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: $" + totalCost);
    }
}

class Main {
    public static void main(String[] args) {
        CarRental c1 = new CarRental();
        c1.display();

        System.out.println();

        CarRental c2 = new CarRental("Alice", "Sedan", 3);
        c2.display();
    }
}
