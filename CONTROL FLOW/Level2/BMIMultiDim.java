import java.util.Scanner;

public class BMIMultiDim {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = input.nextInt();

        double[][] personData = new double[n][3]; // 0=weight, 1=height, 2=BMI
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            double w, h;
            do {
                System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
                w = input.nextDouble();
                System.out.print("Enter height (cm): ");
                h = input.nextDouble();
                if (w < 0 || h < 0) System.out.println("Enter positive values.");
            } while (w < 0 || h < 0);

            personData[i][0] = w;
            personData[i][1] = h / 100.0;
            personData[i][2] = w / (personData[i][1] * personData[i][1]);

            double bmi = personData[i][2];
            if (bmi < 18.5) status[i] = "Underweight";
            else if (bmi < 25) status[i] = "Normal";
            else if (bmi < 30) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d: Weight=%.2f kg, Height=%.2f m, BMI=%.2f, Status=%s%n",
                    i + 1, personData[i][0], personData[i][1], personData[i][2], status[i]);
        }
    }
}
