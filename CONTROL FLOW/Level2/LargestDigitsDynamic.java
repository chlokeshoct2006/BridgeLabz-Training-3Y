import java.util.Arrays;
import java.util.Scanner;

public class LargestDigitsDynamic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = input.nextLong();

        int maxDigit = 10, index = 0;
        int[] digits = new int[maxDigit];

        while (number != 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                digits = Arrays.copyOf(digits, maxDigit);
            }
            digits[index++] = (int)(number % 10);
            number /= 10;
        }

        int largest = -1, second = -1;
        for (int i = 0; i < index; i++) {
            int d = digits[i];
            if (d > largest) {
                second = largest;
                largest = d;
            } else if (d > second && d != largest) {
                second = d;
            }
        }

        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + (second >= 0 ? second : "None"));
    }
}
