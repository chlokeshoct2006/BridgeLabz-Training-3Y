class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

public class EmployeesDetails {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", 101, 50000);
        Employee e2 = new Employee("Bob", 102, 60000);

        e1.displayDetails();
        System.out.println("--------------------");
        e2.displayDetails();
    }
}
