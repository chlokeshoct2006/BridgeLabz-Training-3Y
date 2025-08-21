import java.util.Scanner;

public class StudentVoteChecker {

    public static boolean canStudentVote(int age) {
        if (age < 0) return false;
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] ages = new int[10];

        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            ages[i] = input.nextInt();
        }

        for (int age : ages) {
            boolean canVote = canStudentVote(age);
            if (age < 0) {
                System.out.println("Invalid age: " + age);
            } else if (canVote) {
                System.out.println("Student of age " + age + " can vote.");
            } else {
                System.out.println("Student of age " + age + " cannot vote.");
            }
        }
    }
}
