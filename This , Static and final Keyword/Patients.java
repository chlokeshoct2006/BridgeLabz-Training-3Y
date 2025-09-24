class Patient {
    static String hospitalName = "City Hospital";
    private static int totalPatients = 0;

    private String name;
    private int age;
    private String ailment;
    private final int patientID;

    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    public void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }
}

public class Patients{
    public static void main(String[] args) {
        Patient p1 = new Patient("Raj", 30, "Fever", 101);
        Patient p2 = new Patient("Amit", 45, "Diabetes", 102);

        p1.displayDetails();
        System.out.println();
        p2.displayDetails();

        Patient.getTotalPatients();
    }
}
