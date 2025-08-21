import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        int count = 0;
        int original = Math.abs(number); // Handle negative numbers

        while (original != 0) {
            original /= 10;
            count++;
        }

        System.out.println("Number of digits in " + number + " is: " + count);
    }
}
