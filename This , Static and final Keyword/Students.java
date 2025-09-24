class Student {
    static String universityName = "Global University";
    private static int totalStudents = 0;

    private String name;
    private final int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
        }
    }

    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated for " + name + " to " + grade);
        }
    }
}

public class Students {
    public static void main(String[] args) {
        Student s1 = new Student("Raj", 101, "A");
        Student s2 = new Student("Amit", 102, "B");

        s1.displayDetails();
        System.out.println();
        s2.displayDetails();

        Student.displayTotalStudents();

        System.out.println("\nUpdating grade...");
        s2.updateGrade("A+");
        System.out.println();
        s2.displayDetails();
    }
}
