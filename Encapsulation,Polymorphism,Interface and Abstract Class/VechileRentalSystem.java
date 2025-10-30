import java.util.*;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        if (rentalRate > 0) {
            this.rentalRate = rentalRate;
        }
    }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String policy) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = policy;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.1;
    }

    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + insurancePolicyNumber;
    }
}

class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String vehicleNumber, double rentalRate, String policy) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = policy;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.8;
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.05;
    }

    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + insurancePolicyNumber;
    }
}

class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String policy) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = policy;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.5;
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.2;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + insurancePolicyNumber;
    }
}

public class VechileRentalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();

        System.out.print("Enter number of vehicles to rent: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Vehicle " + (i + 1));
            System.out.print("Enter Vehicle Number: ");
            String vnum = sc.nextLine();
            System.out.print("Enter Rental Rate per Day: ");
            double rate = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter Insurance Policy Number: ");
            String policy = sc.nextLine();
            System.out.print("Enter Vehicle Type (1=Car, 2=Bike, 3=Truck): ");
            int type = sc.nextInt();
            sc.nextLine();

            if (type == 1) {
                vehicles.add(new Car(vnum, rate, policy));
            } else if (type == 2) {
                vehicles.add(new Bike(vnum, rate, policy));
            } else if (type == 3) {
                vehicles.add(new Truck(vnum, rate, policy));
            } else {
                System.out.println("Invalid type, skipping...");
            }
        }

        System.out.print("\nEnter number of rental days: ");
        int days = sc.nextInt();

        System.out.println("\nRental Summary");
        for (Vehicle v : vehicles) {
            double rentalCost = v.calculateRentalCost(days);
            double insuranceCost = (v instanceof Insurable) ? ((Insurable) v).calculateInsurance() : 0;
            System.out.println("Vehicle: " + v.getType() + " (" + v.getVehicleNumber() + ")");
            System.out.println("Rental Cost for " + days + " days: " + rentalCost);
            if (v instanceof Insurable) {
                System.out.println("Insurance: " + insuranceCost);
                System.out.println(((Insurable) v).getInsuranceDetails());
            }
            
        }

        sc.close();
    }
}
