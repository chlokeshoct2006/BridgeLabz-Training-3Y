// The Classroom Test Scores
//A teacher records the marks of 12 students in an array.
//Use a loop to calculate the class average.
//Find the highest and lowest marks.
//Count how many students scored above the average.
// Display a message if any student scored below passing marks (say 40).


package workshop;
import java.util.Scanner;

public class ClassroomTestScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] marks = new int[12];
        int sum = 0;
        int highest, lowest;
        int countAboveAverage = 0;
        boolean hasFailed = false;
        int count=0;

        System.out.println("Enter marks of 12 students:");
        for (int i = 0; i < marks.length; i++) {
            marks[i] = sc.nextInt();
            sum += marks[i];
        }

        double average = (double) sum / marks.length;
        highest = marks[0];
        lowest = marks[0];

        for (int i = 0; i < marks.length; i++) {
            if (marks[i] > highest) {
                highest = marks[i];
            }
            if (marks[i] < lowest) {
                lowest = marks[i];
            }
            if (marks[i] > average) {
                countAboveAverage++;
            }
            if (marks[i] < 40) {
                hasFailed = true;
                count++;
            }
        }

        System.out.println("Class Average: " + average);
        System.out.println("Highest Marks: " + highest);
        System.out.println("Lowest Marks: " + lowest);
        System.out.println("Students scoring above average: " + countAboveAverage);

        if (hasFailed) {
            System.out.println("Students scored below passing marks (40): "+count);
        } else {
            System.out.println("All students passed.");
        }
    }
}
