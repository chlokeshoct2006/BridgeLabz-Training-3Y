import java.util.*;

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }
}

class University {
    private String uniName;
    private List<Department> departments;
    private List<Faculty> faculties;

    public University(String uniName) {
        this.uniName = uniName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addFaculty(Faculty f) {
        faculties.add(f);
    }

    public void showUniversity() {
        System.out.println("\nUniversity: " + uniName);
        System.out.println("Departments:");
        for (Department d : departments) {
            System.out.println(" - " + d.getDeptName());
        }
        System.out.println("Faculties:");
        for (Faculty f : faculties) {
            System.out.println(" - " + f.getName());
        }
    }

    public void closeUniversity() {
        System.out.println("\nClosing University: " + uniName);
        departments.clear();
    }
}

public class UniversityApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter university name: ");
        String uniName = sc.nextLine();
        University uni = new University(uniName);

        System.out.print("Enter number of departments: ");
        int dCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < dCount; i++) {
            System.out.print("Enter department name: ");
            String dname = sc.nextLine();
            uni.addDepartment(dname);
        }

        System.out.print("Enter number of faculties: ");
        int fCount = sc.nextInt();
        sc.nextLine();
        List<Faculty> facultyList = new ArrayList<>();
        for (int i = 0; i < fCount; i++) {
            System.out.print("Enter faculty name: ");
            String fname = sc.nextLine();
            Faculty f = new Faculty(fname);
            facultyList.add(f);
            uni.addFaculty(f);
        }

        uni.showUniversity();

        System.out.print("\nDo you want to close the university? (yes/no): ");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            uni.closeUniversity();
            uni.showUniversity();
        }

        System.out.println("\nFaculties still exist independently:");
        for (Faculty f : facultyList) {
            System.out.println(" - " + f.getName());
        }

        sc.close();
    }
}
