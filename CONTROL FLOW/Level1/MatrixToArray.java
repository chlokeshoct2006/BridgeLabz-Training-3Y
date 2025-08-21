import java.util.Scanner;
import java.util.Arrays;

public class MatrixToArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = input.nextInt();
        System.out.print("Enter columns: ");
        int cols = input.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = input.nextInt();

        int[] flatArray = new int[rows * cols];
        int idx = 0;
        for (int[] row : matrix)
            for (int val : row)
                flatArray[idx++] = val;

        System.out.println("Flattened Array: " + Arrays.toString(flatArray));
    }
}
