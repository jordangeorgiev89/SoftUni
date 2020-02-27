package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int maxSum = -1;
        int rowIndex = -1;
        int colIndex = -1;
        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                int currentSum = getMatrixSum(matrix, row, col);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    rowIndex = row;
                    colIndex = col;
                }
            }
        }
    }

    private static int getMatrixSum(int[][] matrix, int row, int col) {
        int sum = 0;

        sum += matrix[row][col];
        sum += matrix[row - 1][col];
        sum += matrix[row + 1][col];
        sum += matrix[row][col - 1];
        sum += matrix[row][col + 1];
        sum += matrix[row - 1][col - 1];
        sum += matrix[row + 1][col + 1];
        sum += matrix[row + 1][col - 1];
        sum += matrix[row - 1][col + 1];

        return sum;
    }
}
