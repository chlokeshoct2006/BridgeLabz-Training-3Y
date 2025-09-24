import java.util.Scanner;

public class PalindromeCheck {

    // Logic 1: Iterative comparison
    public static boolean isPalindromeIterative(String text) {
        int start = 0, end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }

    // Logic 2: Recursive comparison
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Reverse string
    public static boolean isPalindromeByReverse(String text) {
        char[] arr = text.toCharArray();
        String rev = "";
        for (int i = arr.length - 1; i >= 0; i--) rev += arr[i];
        return text.equals(rev);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Iterative: " + isPalindromeIterative(text));
        System.out.println("Recursive: " + isPalindromeRecursive(text, 0, text.length() - 1));
        System.out.println("By Reverse: " + isPalindromeByReverse(text));

        sc.close();
    }
}
