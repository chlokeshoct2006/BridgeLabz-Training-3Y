import java.util.Scanner;

public class FactorsAnalysis {

    // Method to find factors and return as an int array
    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }
        int[] factors = new int[count];
        int idx = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[idx++] = i;
            }
        }
        return factors;
    }

    public static int sumOfFactors(int[] arr) {
        int sum = 0;
        for (int val : arr) sum += val;
        return sum;
    }

    public static int sumOfSquares(int[] arr) {
        int sumSq = 0;
        for (int val : arr) sumSq += val * val;
        return sumSq;
    }

    public static long productOfFactors(int[] arr) {
        long prod = 1;
        for (int val : arr) prod *= val;
        return prod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Invalid input. Please enter a positive integer.");
            return;
        }

        int[] factors = findFactors(number);
        System.out.print("Factors: ");
        for (int f : factors) System.out.print(f + " ");
        System.out.println();

        System.out.println("Sum of factors: " + sumOfFactors(factors));
        System.out.println("Sum of squares of factors: " + sumOfSquares(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
    }
}
