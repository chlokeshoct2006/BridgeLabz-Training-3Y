import java.util.Scanner;

public class StringSplitDemo {

    // Method to find length without length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }

    // Method to split words manually
    public static String[] manualSplit(String str) {
        int n = findLength(str);
        int spaceCount = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == ' ') spaceCount++;
        }
        String[] words = new String[spaceCount + 1];
        int start = 0, index = 0;
        for (int i = 0; i <= n; i++) {
            if (i == n || str.charAt(i) == ' ') {
                StringBuilder sb = new StringBuilder();
                for (int j = start; j < i; j++) sb.append(str.charAt(j));
                words[index++] = sb.toString();
                start = i + 1;
            }
        }
        return words;
    }

    // Compare two arrays
    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[] manual = manualSplit(input);
        String[] builtin = input.split(" ");

        System.out.println("Manual Split:");
        for (String w : manual) System.out.println(w);

        System.out.println("Built-in Split:");
        for (String w : builtin) System.out.println(w);

        System.out.println("Arrays equal? " + compareArrays(manual, builtin));

        sc.close();
    }
}
