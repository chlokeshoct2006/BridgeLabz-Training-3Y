import java.util.Scanner;

public class CharFrequencyUnique {

    public static char[] uniqueCharacters(String text) {
        int length = text.length();
        char[] temp = new char[length];
        int count = 0;

        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == c) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) temp[count++] = c;
        }

        char[] result = new char[count];
        System.arraycopy(temp, 0, result, 0, count);
        return result;
    }

    public static String[][] findFrequency(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        char[] uniques = uniqueCharacters(text);
        String[][] result = new String[uniques.length][2];

        for (int i = 0; i < uniques.length; i++) {
            result[i][0] = String.valueOf(uniques[i]);
            result[i][1] = String.valueOf(freq[uniques[i]]);
        }

        return result;
    }

    public static void display(String[][] result) {
        System.out.println("Character  Frequency");
        for (String[] row : result) {
            System.out.println(row[0] + "           " + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] result = findFrequency(text);
        display(result);

        sc.close();
    }
}
