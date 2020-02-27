package MultidimensionalArrays;

import java.util.Scanner;

public class DiagonalDifference1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        System.out.println();

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            String[] line = sc.nextLine().split("\\s+");
            for (int col = 0; col < line.length; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
        int row = 0, col = 0;
        int primarySum = 0;
        while (row < size && col < size) {
            primarySum += matrix[row][col];
            row++;
            col++;
        }

        row--;
        col = 0;

        int secondaySum = 0;
        while (row >= 0 && col < size) {
            secondaySum += matrix[row][col];
            row--;
            col++;
        }
        System.out.println(Math.abs(primarySum - secondaySum));
    }
}
