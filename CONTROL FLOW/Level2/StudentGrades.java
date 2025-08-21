import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        int[] phys = new int[n], chem = new int[n], maths = new int[n];
        double[] percent = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter marks for student %d (Physics, Chemistry, Maths): ", i + 1);
            phys[i] = input.nextInt();
            chem[i] = input.nextInt();
            maths[i] = input.nextInt();

            if (phys[i] < 0 || chem[i] < 0 || maths[i] < 0) {
                System.out.println("Negative marks not allowed. Re-enter data.");
                i--;
                continue;
            }

            percent[i] = (phys[i] + chem[i] + maths[i]) / 3.0;
            double p = percent[i];

            if (p >= 90) grade[i] = "A+";
            else if (p >= 80) grade[i] = "A";
            else if (p >= 70) grade[i] = "B";
            else if (p >= 60) grade[i] = "C";
            else grade[i] = "D";
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("Student %d: P=%.2f%%, Grade=%s%n", i + 1, percent[i], grade[i]);
        }
    }
}
