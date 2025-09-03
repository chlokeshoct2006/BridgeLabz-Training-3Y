//The Fitness Center Attendance
//        A gym tracks attendance for 10 days using an array.
//        Use a for loop to calculate the total number of visitors in 10 days.
//        Identify the day with the maximum attendance.
//        Find the minimum attendance day.
//        Display all days where attendance was above the average.


package workshop;
import java.util.*;

public class FitnessCenterAttendance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] attendance = new int[10];
        int sum = 0;

        System.out.println("Enter attendance for 10 days:");
        for (int i = 0; i < 10; i++) {
            attendance[i] = sc.nextInt();
            sum += attendance[i];
        }

        // Average
        double average = (double) sum / 10;

        // Initialize max and min with day 1
        int maxAttendance = attendance[0];
        int minAttendance = attendance[0];
        int maxDay = 1;
        int minDay = 1;

        // Find max & min day
        for (int i = 1; i < 10; i++) {
            if (attendance[i] > maxAttendance) {
                maxAttendance = attendance[i];
                maxDay = i + 1;
            }
            if (attendance[i] < minAttendance) {
                minAttendance = attendance[i];
                minDay = i + 1;
            }
        }

        // Output results
        System.out.println("Total visitors in 10 days: " + sum);
        System.out.println("Average attendance: " + average);
        System.out.println("Day " + maxDay + " had the maximum attendance: " + maxAttendance);
        System.out.println("Day " + minDay + " had the minimum attendance: " + minAttendance);

        // Days above average
        System.out.println("Days with attendance above average:");
        for (int i = 0; i < 10; i++) {
            if (attendance[i] > average) {
                System.out.println("Day " + (i + 1) + ": " + attendance[i]);
            }
        }
    }
}
