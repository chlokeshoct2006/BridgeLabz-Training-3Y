import java.util.Scanner;

public class YoungestTallest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ages
        System.out.print("Enter Amar's age: ");
        int age1 = input.nextInt();
        System.out.print("Enter Akbar's age: ");
        int age2 = input.nextInt();
        System.out.print("Enter Anthony's age: ");
        int age3 = input.nextInt();

        // Heights
        System.out.print("Enter Amar's height (in cm): ");
        int h1 = input.nextInt();
        System.out.print("Enter Akbar's height (in cm): ");
        int h2 = input.nextInt();
        System.out.print("Enter Anthony's height (in cm): ");
        int h3 = input.nextInt();

        // Youngest
        String youngest = "Amar";
        int minAge = age1;

        if (age2 < minAge) {
            youngest = "Akbar";
            minAge = age2;
        }
        if (age3 < minAge) {
            youngest = "Anthony";
        }

        // Tallest
        String tallest = "Amar";
        int maxHeight = h1;

        if (h2 > maxHeight) {
            tallest = "Akbar";
            maxHeight = h2;
        }
        if (h3 > maxHeight) {
            tallest = "Anthony";
        }

        System.out.println("The youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);
    }
}
