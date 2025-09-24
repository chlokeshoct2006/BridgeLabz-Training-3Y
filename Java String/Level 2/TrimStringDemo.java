import java.util.Scanner;

public class TrimStringDemo {

    public static int[] findTrimIndices(String str) {
        int n = str.length();
        int start = 0, end = n - 1;
        while (start < n && str.charAt(start) == ' ') start++;
        while (end >= 0 && str.charAt(end) == ' ') end--;
        return new int[]{start, end};
    }

    public static String manualSubstring(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) sb.append(str.charAt(i));
        return sb.toString();
    }

    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text with spaces: ");
        String input = sc.nextLine();

        int[] indices = findTrimIndices(input);
        String trimmedManual = manualSubstring(input, indices[0], indices[1]);
        String trimmedBuiltIn = input.trim();

        System.out.println("Manual Trim: [" + trimmedManual + "]");
        System.out.println("Built-in Trim: [" + trimmedBuiltIn + "]");
        System.out.println("Equal? " + compareStrings(trimmedManual, trimmedBuiltIn));

        sc.close();
    }
}
