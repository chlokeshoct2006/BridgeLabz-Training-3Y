import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI and return status
    public static String[] calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100; // cm -> meters
        double bmi = weight / (heightM * heightM);

        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 24.9) {
            status = "Normal";
        } else if (bmi < 29.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{String.valueOf(bmi), status};
    }

    // Method to combine Height, Weight, BMI and Status
    public static String[][] processBMI(double[][] hwArray) {
        String[][] result = new String[hwArray.length][4];
        for (int i = 0; i < hwArray.length; i++) {
            double weight = hwArray[i][0];
            double height = hwArray[i][1];
            String[] bmiData = calculateBMI(weight, height);

            result[i][0] = String.valueOf(weight);
            result[i][1] = String.valueOf(height);
            result[i][2] = bmiData[0];
            result[i][3] = bmiData[1];
        }
        return result;
    }

    // Method to display results
    public static void displayResults(String[][] data) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Weight", "Height", "BMI", "Status");
        for (String[] row : data) {
            System.out.printf("%-10s %-10s %-10s %-15s\n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] hwArray = new double[10][2];

        System.out.println("Enter weight (kg) and height (cm) of 10 members:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Member " + (i + 1) + " - Weight (kg): ");
            hwArray[i][0] = sc.nextDouble();
            System.out.print("Member " + (i + 1) + " - Height (cm): ");
            hwArray[i][1] = sc.nextDouble();
        }

        String[][] results = processBMI(hwArray);
        System.out.println("\n--- BMI Report ---");
        displayResults(results);

        sc.close();
    }
}
