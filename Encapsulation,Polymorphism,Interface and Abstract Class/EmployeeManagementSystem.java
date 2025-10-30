import java.util.*;

abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Salary: " + calculateSalary());
    }
}

interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    public double calculateSalary() {
        return getBaseSalary();
    }

    public void assignDepartment(String dept) {
        this.department = dept;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;
    private String department;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    public void assignDepartment(String dept) {
        this.department = dept;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter type (1 = FullTime, 2 = PartTime): ");
            int type = sc.nextInt();
            sc.nextLine();

            if (type == 1) {
                System.out.print("Enter Base Salary: ");
                double salary = sc.nextDouble();
                sc.nextLine();
                FullTimeEmployee fte = new FullTimeEmployee(id, name, salary);
                System.out.print("Enter Department: ");
                String dept = sc.nextLine();
                fte.assignDepartment(dept);
                employees.add(fte);
            } else if (type == 2) {
                System.out.print("Enter Hourly Rate: ");
                double rate = sc.nextDouble();
                System.out.print("Enter Hours Worked: ");
                int hours = sc.nextInt();
                sc.nextLine();
                PartTimeEmployee pte = new PartTimeEmployee(id, name, rate, hours);
                System.out.print("Enter Department: ");
                String dept = sc.nextLine();
                pte.assignDepartment(dept);
                employees.add(pte);
            } else {
                System.out.println("Invalid type, skipping...");
            }
        }

        System.out.println("\n=== Employee Details ===");
        for (Employee e : employees) {
            e.displayDetails();
            if (e instanceof Department) {
                System.out.println("Department: " + ((Department) e).getDepartmentDetails());
            }
        }

        sc.close();
    }
}
