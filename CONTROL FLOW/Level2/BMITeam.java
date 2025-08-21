import java.util.Scanner;

public class BMITeam {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = input.nextInt();

        double[] weights = new double[n];
        double[] heights = new double[n];
        double[] bmis = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            weights[i] = input.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            heights[i] = input.nextDouble();

            double hM = heights[i] / 100.0;
            bmis[i] = weights[i] / (hM * hM);

            if (bmis[i] < 18.5) status[i] = "Underweight";
            else if (bmis[i] < 25) status[i] = "Normal";
            else if (bmis[i] < 30) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d: Weight=%.2f kg, Height=%.2f cm, BMI=%.2f, Status=%s%n",
                    i + 1, weights[i], heights[i], bmis[i], status[i]);
        }
    }
}
