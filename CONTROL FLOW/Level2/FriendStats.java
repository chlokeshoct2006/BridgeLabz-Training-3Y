import java.util.Scanner;

public class FriendStats {

    public static int findYoungest(double[] ages) {
        int idx = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[idx]) idx = i;
        }
        return idx;
    }

    public static int findTallest(double[] heights) {
        int idx = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[idx]) idx = i;
        }
        return idx;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        double[] ages = new double[3], heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter " + names[i] + "'s age: ");
            ages[i] = input.nextDouble();
            System.out.print("Enter " + names[i] + "'s height (cm): ");
            heights[i] = input.nextDouble();
        }

        int youngest = findYoungest(ages);
        int tallest = findTallest(heights);

        System.out.println("Youngest: " + names[youngest]);
        System.out.println("Tallest: " + names[tallest]);
    }
}
