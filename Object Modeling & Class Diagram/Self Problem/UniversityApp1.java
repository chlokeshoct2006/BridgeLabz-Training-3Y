import java.util.*;

class Professor {
    private String name;
    private List<Course> courses;

    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignCourse(Course c) {
        if (!courses.contains(c)) {
            courses.add(c);
            c.assignProfessor(this);
        }
    }

    public void showCourses() {
        System.out.println("Professor " + name + " teaches:");
        for (Course c : courses) {
            System.out.println(" - " + c.getName());
        }
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course c) {
        if (!courses.contains(c)) {
            courses.add(c);
            c.addStudent(this);
        }
    }

    public void showCourses() {
        System.out.println("Student " + name + " is enrolled in:");
        for (Course c : courses) {
            System.out.println(" - " + c.getName());
        }
    }
}

class Course {
    private String name;
    private Professor professor;
    private List<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignProfessor(Professor p) {
        this.professor = p;
    }

    public void addStudent(Student s) {
        if (!students.contains(s)) {
            students.add(s);
        }
    }

    public void showCourse() {
        System.out.println("\nCourse: " + name);
        if (professor != null) {
            System.out.println("Professor: " + professor.getName());
        } else {
            System.out.println("No professor assigned");
        }
        System.out.println("Students:");
        for (Student s : students) {
            System.out.println(" - " + s.getName());
        }
    }
}

public class UniversityApp1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of professors: ");
        int pCount = sc.nextInt();
        sc.nextLine();
        List<Professor> professors = new ArrayList<>();
        for (int i = 0; i < pCount; i++) {
            System.out.print("Enter professor name: ");
            String pname = sc.nextLine();
            professors.add(new Professor(pname));
        }

        System.out.print("Enter number of courses: ");
        int cCount = sc.nextInt();
        sc.nextLine();
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < cCount; i++) {
            System.out.print("Enter course name: ");
            String cname = sc.nextLine();
            courses.add(new Course(cname));
        }

        System.out.print("Enter number of students: ");
        int sCount = sc.nextInt();
        sc.nextLine();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < sCount; i++) {
            System.out.print("Enter student name: ");
            String sname = sc.nextLine();
            students.add(new Student(sname));
        }

        System.out.print("Enter number of professor-course assignments: ");
        int assignCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < assignCount; i++) {
            System.out.print("Enter professor name: ");
            String pname = sc.nextLine();
            System.out.print("Enter course name: ");
            String cname = sc.nextLine();

            Professor prof = null;
            for (Professor p : professors) {
                if (p.getName().equalsIgnoreCase(pname)) {
                    prof = p;
                    break;
                }
            }

            Course course = null;
            for (Course c : courses) {
                if (c.getName().equalsIgnoreCase(cname)) {
                    course = c;
                    break;
                }
            }

            if (prof != null && course != null) {
                prof.assignCourse(course);
            }
        }

        System.out.print("Enter number of student-course enrollments: ");
        int enrollCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < enrollCount; i++) {
            System.out.print("Enter student name: ");
            String sname = sc.nextLine();
            System.out.print("Enter course name: ");
            String cname = sc.nextLine();

            Student stud = null;
            for (Student s : students) {
                if (s.getName().equalsIgnoreCase(sname)) {
                    stud = s;
                    break;
                }
            }

            Course course = null;
            for (Course c : courses) {
                if (c.getName().equalsIgnoreCase(cname)) {
                    course = c;
                    break;
                }
            }

            if (stud != null && course != null) {
                stud.enrollCourse(course);
            }
        }

        System.out.println("\n--- University Data ---");
        for (Professor p : professors) {
            p.showCourses();
        }
        for (Student s : students) {
            s.showCourses();
        }
        for (Course c : courses) {
            c.showCourse();
        }

        sc.close();
    }
}
