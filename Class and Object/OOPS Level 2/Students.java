class Student {
    String name;
    int rollNumber;
    int marks;

  
    Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    
    String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 40) return "D";
        else return "F";
    }

    
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
        
    }
}

public class Students {
    public static void main(String[] args) {
       
        Student s1 = new Student("Alice", 101, 92);
        Student s2 = new Student("Bob", 102, 76);
        Student s3 = new Student("Charlie", 103, 45);
        Student s4 = new Student("David", 104, 30);

        
        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();
        s4.displayDetails();
    }
}
