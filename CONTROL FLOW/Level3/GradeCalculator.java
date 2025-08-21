import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter marks in Physics: ");
        int physics = input.nextInt();
        System.out.print("Enter marks in Chemistry: ");
        int chemistry = input.nextInt();
        System.out.print("Enter marks in Maths: ");
        int maths = input.nextInt();

        int total = physics + chemistry + maths;
        double percentage = total / 3.0;

        System.out.println("Average Percentage: " + percentage + "%");

        if (percentage >= 90) {
            System.out.println("Grade: A+ | Remarks: Excellent");
        } else if (percentage >= 80) {
            System.out.println("Grade: A | Remarks: Very Good");
        } else if (percentage >= 70) {
            System.out.println("Grade: B | Remarks: Good");
        } else if (percentage >= 60) {
            System.out.println("Grade: C | Remarks: Satisfactory");
        } else {
            System.out.println("Grade: D | Remarks: Needs Improvement");
        }
    }
}
