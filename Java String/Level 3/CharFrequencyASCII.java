import java.util.Scanner;

public class CharFrequencyASCII {

    public static String[][] findFrequency(String text) {
        int[] freq = new int[256];
        int length = text.length();

        for (int i = 0; i < length; i++) {
            freq[text.charAt(i)]++;
        }

        int uniqueCount = 0;
        for (int f : freq) if (f > 0) uniqueCount++;

        String[][] result = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[index][0] = String.valueOf((char) i);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
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
