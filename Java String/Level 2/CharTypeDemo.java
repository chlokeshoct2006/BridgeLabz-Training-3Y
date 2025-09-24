import java.util.Scanner;

public class CharTypeDemo {

    public static String checkChar(char c) {
        if (c >= 'A' && c <= 'Z') c = (char)(c + 32);
        if (c >= 'a' && c <= 'z') {
            if ("aeiou".indexOf(c) != -1) return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }

    public static String[][] charType(String str) {
        String[][] res = new String[str.length()][2];
        for (int i = 0; i < str.length(); i++) {
            res[i][0] = String.valueOf(str.charAt(i));
            res[i][1] = checkChar(str.charAt(i));
        }
        return res;
    }

    public static void display(String[][] arr) {
        System.out.println("Char\tType");
        for (String[] row : arr) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[][] result = charType(input);
        display(result);

        sc.close();
    }
}
