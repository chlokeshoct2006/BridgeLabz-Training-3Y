import java.util.Scanner;

public class FriendsDetails {

    public static int findYoungest(double[] ages) {
        int youngest = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngest]) youngest = i;
        }
        return youngest;
    }

    public static int findTallest(double[] heights) {
        int tallest = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallest]) tallest = i;
        }
        return tallest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        double[] ages = new double[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextDouble();
            System.out.print("Enter height of " + names[i] + " (in cm): ");
            heights[i] = sc.nextDouble();
        }

        int youngest = findYoungest(ages);
        int tallest = findTallest(heights);

        System.out.println("Youngest friend is: " + names[youngest]);
        System.out.println("Tallest friend is: " + names[tallest]);
    }
}
