class Course {
    String courseName;
    int duration; // in weeks

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayDetails() {
        System.out.println("Course -> Name: " + courseName + ", Duration: " + duration + " weeks");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayDetails() {
        System.out.println("Online Course -> Name: " + courseName + ", Duration: " + duration +
                           " weeks, Platform: " + platform + ", Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount; // in percentage

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    double getFinalFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    void displayDetails() {
        System.out.println("Paid Online Course -> Name: " + courseName + ", Duration: " + duration +
                           " weeks, Platform: " + platform + ", Recorded: " + (isRecorded ? "Yes" : "No") +
                           ", Fee: $" + fee + ", Discount: " + discount + "%, Final Fee: $" + getFinalFee());
    }
}

public class CourseHiearachy {
    public static void main(String[] args) {
        Course c = new Course("Mathematics Basics", 6);
        OnlineCourse oc = new OnlineCourse("Java Programming", 8, "Coursera", true);
        PaidOnlineCourse poc = new PaidOnlineCourse("Data Science", 12, "Udemy", true, 200.0, 20.0);

        c.displayDetails();
        oc.displayDetails();
        poc.displayDetails();
    }
}

