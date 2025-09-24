import java.util.*;
class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void showEmployee() {
        System.out.println("  Employee: " + name + " (" + role + ")");
    }
}
class Department {
    private String deptName;
    private List<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }
    public void addEmployee(String name, String role) {
        employees.add(new Employee(name, role));
    }
    public void showDepartment() {
        System.out.println(" Department: " + deptName);
        for (Employee emp : employees) {
            emp.showEmployee();
        }
    }
}

class Company {
    private String companyName;
    private List<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public Department addDepartment(String deptName) {
        Department dept = new Department(deptName);
        departments.add(dept);
        return dept;
    }

    public void showCompany() {
        System.out.println("\n Company: " + companyName);
        for (Department dept : departments) {
            dept.showDepartment();
        }
    }
    public void closeCompany() {
        System.out.println("\n Closing company: " + companyName);
        departments.clear();
    }
}


public class CompanyApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter company name: ");
        String compName = sc.nextLine();
        Company company = new Company(compName);

        System.out.print("Enter number of departments: ");
        int deptCount = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < deptCount; i++) {
            System.out.print("\nEnter department name: ");
            String deptName = sc.nextLine();
            Department dept = company.addDepartment(deptName);

            System.out.print("Enter number of employees in " + deptName + ": ");
            int empCount = sc.nextInt();
            sc.nextLine(); 

            for (int j = 0; j < empCount; j++) {
                System.out.print("Enter employee name: ");
                String empName = sc.nextLine();
                System.out.print("Enter employee role: ");
                String empRole = sc.nextLine();
                dept.addEmployee(empName, empRole);
            }
        }

      
        company.showCompany();

        
        System.out.print("\nDo you want to close the company? (yes/no): ");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            company.closeCompany();
            company.showCompany(); // will be empty
        }

        sc.close();
    }
}
