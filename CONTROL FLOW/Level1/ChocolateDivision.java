import java.util.Scanner;

public class ChocolateDivision {
    public static int[] findRemainderAndQuotient(int total, int children) {
        return new int[]{total % children, total / children};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of chocolates: ");
        int chocolates = sc.nextInt();
        System.out.print("Enter number of children: ");
        int children = sc.nextInt();

        int[] result = findRemainderAndQuotient(chocolates, children);
        System.out.println("Each child gets: " + result[1]);
        System.out.println("Remaining chocolates: " + result[0]);
    }
}
