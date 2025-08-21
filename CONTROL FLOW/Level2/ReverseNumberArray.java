import java.util.Scanner;

public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = input.nextLong();

        int[] digits = new int[20]; // Enough for most numbers
        int index = 0, temp = (int)Math.abs(number);

        while (temp != 0) {
            digits[index++] = temp % 10;
            temp /= 10;
        }

        System.out.print("Reversed: ");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }
}
