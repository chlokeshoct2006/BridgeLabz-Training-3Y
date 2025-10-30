import java.util.*;

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public String getVehicleDetails() {
        return "VehicleID: " + vehicleId + ", Driver: " + driverName + ", Rate/Km: " + ratePerKm;
    }

    public abstract double calculateFare(double distance);
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Vehicle> rides = new ArrayList<>();

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Vehicle " + (i + 1));
            System.out.print("Enter Vehicle ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Driver Name: ");
            String driver = sc.nextLine();
            System.out.print("Enter Rate per Km: ");
            double rate = sc.nextDouble();
            System.out.print("Enter Vehicle Type (1=Car, 2=Bike, 3=Auto): ");
            int type = sc.nextInt();
            sc.nextLine();

            Vehicle v = null;
            if (type == 1) v = new Car(id, driver, rate);
            else if (type == 2) v = new Bike(id, driver, rate);
            else if (type == 3) v = new Auto(id, driver, rate);

            if (v instanceof GPS) {
                System.out.print("Enter Current Location: ");
                String loc = sc.nextLine();
                ((GPS) v).updateLocation(loc);
            }
            rides.add(v);
        }

        System.out.print("\nEnter ride distance (km): ");
        double distance = sc.nextDouble();

        System.out.println("\n=== Ride Fare Details ===");
        for (Vehicle v : rides) {
            System.out.println(v.getVehicleDetails());
            if (v instanceof GPS) {
                System.out.println("Location: " + ((GPS) v).getCurrentLocation());
            }
            System.out.println("Fare: " + v.calculateFare(distance));
        }

        sc.close();
    }
}

