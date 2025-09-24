class Vehicle {
    static double registrationFee = 5000.0;

    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: " + registrationFee);
        }
    }
}

public class Vehicles {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Raj", "Car", "UP16AB1234");
        Vehicle v2 = new Vehicle("Amit", "Bike", "DL05XY5678");

        v1.displayDetails();
        System.out.println();
        v2.displayDetails();

        Vehicle.updateRegistrationFee(6000.0);
        System.out.println("\nAfter updating registration fee:\n");
        v1.displayDetails();
        System.out.println();
        v2.displayDetails();
    }
}
