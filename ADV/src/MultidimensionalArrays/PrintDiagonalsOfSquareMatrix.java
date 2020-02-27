package MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );
        int rows = Integer.parseInt(in.readLine());

        String[][] matrix = new String[rows][rows];

        List<String> firstDiagonal = new ArrayList<>();
        List<String> secondDiagonal = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            String[] strForCols = in.readLine().split("\\s+");

            matrix[row] = strForCols;
        }

        for (int i = 0; i < rows; i++) {
            firstDiagonal.add(matrix[i][i]);
        }

        int counter = 0;

        for (int i = rows - 1; i >= 0; i--) {
            secondDiagonal.add(matrix[i][counter]);
            counter++;
        }
        System.out.println(String.join(" ", firstDiagonal));
        System.out.println(String.join(" ", secondDiagonal));
    }
}
