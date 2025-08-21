import java.util.Scanner;
import java.util.Arrays;

public class FactorsDynamicArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int maxSize = 10, idx = 0;
        int[] factors = new int[maxSize];

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                if (idx == maxSize) {
                    maxSize *= 2;
                    factors = Arrays.copyOf(factors, maxSize);
                }
                factors[idx++] = i;
            }
        }

        System.out.println("Factors: " + Arrays.toString(Arrays.copyOf(factors, idx)));
    }
}
