import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        int[][] marks = new int[n][3]; // [][0]=phys, [][1]=chem, [][2]=math
        double[] percent = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter marks for student %d (Physics, Chemistry, Maths): ", i + 1);
            for (int j = 0; j < 3; j++) {
                marks[i][j] = input.nextInt();
                if (marks[i][j] < 0) {
                    System.out.println("Negative marks not allowed. Re-enter student.");
                    i--;
                    j = 3; // break inner loop
                }
            }

            double sum = marks[i][0] + marks[i][1] + marks[i][2];
            percent[i] = sum / 3.0;

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
