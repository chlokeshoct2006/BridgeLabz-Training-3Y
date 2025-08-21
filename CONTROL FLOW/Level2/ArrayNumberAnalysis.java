import java.util.Scanner;

public class ArrayNumberAnalysis {

    public static boolean isPositive(int num) {
        return num >= 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    // Returns 1 if n1 > n2, 0 if equal, -1 if n1 < n2
    public static int compare(int n1, int n2) {
        return Integer.compare(n1, n2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }

        for (int num : arr) {
            if (!isPositive(num)) {
                System.out.println(num + " is Negative");
            } else {
                System.out.println(num + " is " + (isEven(num) ? "Even" : "Odd"));
            }
        }

        int first = arr[0], last = arr[arr.length - 1];
        int cmp = compare(first, last);
        if (cmp > 0) System.out.println("First element is greater than the last.");
        else if (cmp < 0) System.out.println("First element is less than the last.");
        else System.out.println("First and last elements are equal.");
    }
}
