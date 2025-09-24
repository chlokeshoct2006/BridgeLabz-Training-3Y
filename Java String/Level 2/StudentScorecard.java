import java.util.Random;

public class StudentScorecard {

    public static int[][] generateMarks(int n) {
        Random r = new Random();
        int[][] marks = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = r.nextInt(41) + 60; // random 60–100
            }
        }
        return marks;
    }

    public static double[][] calculateResults(int[][] marks) {
        double[][] res = new double[marks.length][3];
        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            double perc = (total / 300.0) * 100.0;
            res[i][0] = total;
            res[i][1] = Math.round(avg * 100.0) / 100.0;
            res[i][2] = Math.round(perc * 100.0) / 100.0;
        }
        return res;
    }

    public static String[] assignGrades(double[][] res) {
        String[] grades = new String[res.length];
        for (int i = 0; i < res.length; i++) {
            double perc = res[i][2];
            if (perc >= 90) grades[i] = "A+";
            else if (perc >= 80) grades[i] = "A";
            else if (perc >= 70) grades[i] = "B";
            else if (perc >= 60) grades[i] = "C";
            else grades[i] = "F";
        }
        return grades;
    }

    public static void display(int[][] marks, double[][] res, String[] grades) {
        System.out.println("Phy\tChem\tMath\tTotal\tAvg\tPerc\tGrade");
        for (int i = 0; i < marks.length; i++) {
            System.out.println(marks[i][0] + "\t" + marks[i][1] + "\t" + marks[i][2] +
                    "\t" + (int)res[i][0] + "\t" + res[i][1] + "\t" + res[i][2] + "\t" + grades[i]);
        }
    }

    public static void main(String[] args) {
        int[][] marks = generateMarks(5);
        double[][] results = calculateResults(marks);
        String[] grades = assignGrades(results);
        display(marks, results, grades);
    }
}
