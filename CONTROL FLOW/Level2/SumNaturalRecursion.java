import java.util.Scanner;

public class SumNaturalRecursion {

    public static int sumRecursive(int n) {
        if (n <= 0) return 0;
        return n + sumRecursive(n - 1);
    }

    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer (n): ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Not a natural number.");
            return;
        }

        int sumRec = sumRecursive(n);
        int sumForm = sumFormula(n);

        System.out.println("Sum (Recursion): " + sumRec);
        System.out.println("Sum (Formula):   " + sumForm);
        System.out.println("Results match: " + (sumRec == sumForm));
    }
}
