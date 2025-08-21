import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = Math.abs(input.nextLong());
        int[] freq = new int[10];

        while (number != 0) {
            freq[(int)(number % 10)]++;
            number /= 10;
        }

        for (int d = 0; d < 10; d++) {
            System.out.println("Digit " + d + " appears " + freq[d] + " times.");
        }
    }
}
