import java.util.Scanner;

public class ShortestLongestWord {

    public static int findLength(String str) {
        int count = 0;
        try { while (true) { str.charAt(count); count++; } } 
        catch (Exception e) {}
        return count;
    }

    public static String[] manualSplit(String str) {
        int n = findLength(str);
        int spaceCount = 0;
        for (int i = 0; i < n; i++) if (str.charAt(i) == ' ') spaceCount++;
        String[] words = new String[spaceCount + 1];
        int start = 0, idx = 0;
        for (int i = 0; i <= n; i++) {
            if (i == n || str.charAt(i) == ' ') {
                StringBuilder sb = new StringBuilder();
                for (int j = start; j < i; j++) sb.append(str.charAt(j));
                words[idx++] = sb.toString();
                start = i + 1;
            }
        }
        return words;
    }

    public static String[][] wordWithLength(String[] words) {
        String[][] res = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            res[i][0] = words[i];
            res[i][1] = String.valueOf(findLength(words[i]));
        }
        return res;
    }

    public static String[] findShortestLongest(String[][] arr) {
        String shortest = arr[0][0];
        String longest = arr[0][0];
        int minLen = Integer.parseInt(arr[0][1]);
        int maxLen = minLen;
        for (String[] row : arr) {
            int len = Integer.parseInt(row[1]);
            if (len < minLen) { minLen = len; shortest = row[0]; }
            if (len > maxLen) { maxLen = len; longest = row[0]; }
        }
        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[] words = manualSplit(input);
        String[][] wordLen = wordWithLength(words);
        String[] result = findShortestLongest(wordLen);

        System.out.println("Shortest word: " + result[0]);
        System.out.println("Longest word: " + result[1]);

        sc.close();
    }
}
