

import java.util.*;

class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor d) {
        if (!doctors.contains(d)) {
            doctors.add(d);
        }
    }

    public void showDoctors() {
        System.out.println("Patient " + name + " consulted:");
        for (Doctor d : doctors) {
            System.out.println(" - Dr. " + d.getName());
        }
    }
}

class Doctor {
    private String name;
    private List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void consult(Patient p) {
        if (!patients.contains(p)) {
            patients.add(p);
            p.addDoctor(this);
        }
        System.out.println("Dr. " + name + " consulted patient " + p.getName());
    }

    public void showPatients() {
        System.out.println("Dr. " + name + " has patients:");
        for (Patient p : patients) {
            System.out.println(" - " + p.getName());
        }
    }
}

class Hospital {
    private String hospitalName;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor d) {
        doctors.add(d);
    }

    public void addPatient(Patient p) {
        patients.add(p);
    }

    public void showHospital() {
        System.out.println("\nHospital: " + hospitalName);
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println(" - Dr. " + d.getName());
        }
        System.out.println("Patients:");
        for (Patient p : patients) {
            System.out.println(" - " + p.getName());
        }
    }
}

public class HospitalApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter hospital name: ");
        String hname = sc.nextLine();
        Hospital hospital = new Hospital(hname);

        System.out.print("Enter number of doctors: ");
        int dCount = sc.nextInt();
        sc.nextLine();
        List<Doctor> doctors = new ArrayList<>();
        for (int i = 0; i < dCount; i++) {
            System.out.print("Enter doctor name: ");
            String dname = sc.nextLine();
            Doctor d = new Doctor(dname);
            doctors.add(d);
            hospital.addDoctor(d);
        }

        System.out.print("Enter number of patients: ");
        int pCount = sc.nextInt();
        sc.nextLine();
        List<Patient> patients = new ArrayList<>();
        for (int i = 0; i < pCount; i++) {
            System.out.print("Enter patient name: ");
            String pname = sc.nextLine();
            Patient p = new Patient(pname);
            patients.add(p);
            hospital.addPatient(p);
        }

        System.out.print("Enter number of consultations: ");
        int cCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cCount; i++) {
            System.out.print("Enter doctor name for consultation: ");
            String dname = sc.nextLine();
            System.out.print("Enter patient name for consultation: ");
            String pname = sc.nextLine();

            Doctor foundDoc = null;
            for (Doctor d : doctors) {
                if (d.getName().equalsIgnoreCase(dname)) {
                    foundDoc = d;
                    break;
                }
            }

            Patient foundPat = null;
            for (Patient p : patients) {
                if (p.getName().equalsIgnoreCase(pname)) {
                    foundPat = p;
                    break;
                }
            }

            if (foundDoc != null && foundPat != null) {
                foundDoc.consult(foundPat);
            } else {
                System.out.println("Doctor or Patient not found.");
            }
        }

        hospital.showHospital();

        System.out.println("\n--- Doctor and Patient Consultations ---");
        for (Doctor d : doctors) {
            d.showPatients();
        }
        for (Patient p : patients) {
            p.showDoctors();
        }

        sc.close();
    }
}
