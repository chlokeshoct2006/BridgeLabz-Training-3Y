import java.util.*;

class Course {
    private String courseName;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void showStudents() {
        System.out.println("Course: " + courseName + " has students:");
        for (Student s : students) {
            System.out.println("   " + s.getName());
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

    public void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
        }
    }

    public void showCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course c : courses) {
            System.out.println("   " + c.getCourseName());
        }
    }
}

class School {
    private String schoolName;
    private List<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showSchool() {
        System.out.println("\nSchool: " + schoolName);
        System.out.println("Students enrolled:");
        for (Student s : students) {
            System.out.println(" - " + s.getName());
        }
    }
}

public class SchoolApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter school name: ");
        String schoolName = sc.nextLine();
        School school = new School(schoolName);

        System.out.print("Enter number of courses: ");
        int cCount = sc.nextInt();
        sc.nextLine();
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < cCount; i++) {
            System.out.print("Enter course name: ");
            String cname = sc.nextLine();
            courses.add(new Course(cname));
        }

        System.out.print("\nEnter number of students: ");
        int sCount = sc.nextInt();
        sc.nextLine();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < sCount; i++) {
            System.out.print("\nEnter student name: ");
            String sname = sc.nextLine();
            Student st = new Student(sname);
            school.addStudent(st);
            students.add(st);

            System.out.print("How many courses does " + sname + " want to enroll in? ");
            int num = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < num; j++) {
                System.out.print("Enter course name to enroll: ");
                String cname = sc.nextLine();

                Course found = null;
                for (Course c : courses) {
                    if (c.getCourseName().equalsIgnoreCase(cname)) {
                        found = c;
                        break;
                    }
                }

                if (found != null) {
                    st.enrollCourse(found);
                } else {
                    System.out.println("Course not found!");
                }
            }
        }

        school.showSchool();

        System.out.println("\n--- Student Course Enrollments ---");
        for (Student s : students) {
            s.showCourses();
        }

        System.out.println("\n--- Course Student Enrollments ---");
        for (Course c : courses) {
            c.showStudents();
        }

        sc.close();
    }
}
