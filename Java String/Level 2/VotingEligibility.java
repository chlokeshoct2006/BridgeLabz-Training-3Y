import java.util.Random;

public class VotingEligibility {

    public static int[] generateAges(int n) {
        Random r = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) ages[i] = r.nextInt(90) + 10; // 2-digit age
        return ages;
    }

    public static String[][] checkVoting(int[] ages) {
        String[][] res = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            res[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) res[i][1] = "false";
            else res[i][1] = (ages[i] >= 18) ? "true" : "false";
        }
        return res;
    }

    public static void display(String[][] arr) {
        System.out.println("Age\tCanVote");
        for (String[] row : arr) System.out.println(row[0] + "\t" + row[1]);
    }

    public static void main(String[] args) {
        int[] ages = generateAges(10);
        String[][] result = checkVoting(ages);
        display(result);
    }
}
