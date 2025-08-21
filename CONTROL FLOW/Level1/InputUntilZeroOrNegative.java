import java.util.Scanner;

public class InputUntilZeroOrNegative {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] arr = new double[10];
        double total = 0.0;
        int idx = 0;

        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double num = input.nextDouble();
            if (num <= 0 || idx == arr.length) break;
            arr[idx++] = num;
        }

        for (int i = 0; i < idx; i++) {
            System.out.println("Value " + (i + 1) + ": " + arr[i]);
            total += arr[i];
        }

        System.out.println("Total sum: " + total);
    }
}
