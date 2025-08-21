import java.util.Scanner;
import java.util.Arrays;

public class EvenOddArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        if (number < 1) {
            System.out.println("Error: Natural number required.");
            return;
        }

        int maxSize = number / 2 + 1;
        int[] evens = new int[maxSize], odds = new int[maxSize];
        int eIndex = 0, oIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) evens[eIndex++] = i;
            else odds[oIndex++] = i;
        }

        System.out.println("Even numbers: " + Arrays.toString(Arrays.copyOf(evens, eIndex)));
        System.out.println("Odd numbers: " + Arrays.toString(Arrays.copyOf(odds, oIndex)));
    }
}
