package MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );
        int size = Integer.parseInt(in.readLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            String[] line = in.readLine().split("\\s+");
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

        int secondarySum = 0;

        while (row >= 0 && col < size) {
            secondarySum += matrix[row][col];
            row--;
            col++;

        }
        System.out.println(Math.abs(primarySum - secondarySum));
    }
}
