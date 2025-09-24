import java.util.Scanner;

public class StringLengthDemo {

    // Method to find length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count); // yahan error throw hoga jab index bahar ho jayega
                count++;
            }
        } catch (Exception e) {
            // Runtime exception handle
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        int userLen = findLength(input);
        int builtInLen = input.length();

        System.out.println("User Defined Length: " + userLen);
        System.out.println("Built-in length(): " + builtInLen);

        sc.close();
    }
}
