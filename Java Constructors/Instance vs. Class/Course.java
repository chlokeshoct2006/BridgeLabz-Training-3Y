public class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "ABC Institute";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: " + fee);
        System.out.println("Institute: " + instituteName);
    }

    public static void updateInstituteName(String name) {
        instituteName = name;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 3, 5000);
        Course c2 = new Course("Data Science", 6, 15000);

        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();

        System.out.println("\nUpdating Institute Name...\n");
        Course.updateInstituteName("XYZ Academy");

        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }
}
