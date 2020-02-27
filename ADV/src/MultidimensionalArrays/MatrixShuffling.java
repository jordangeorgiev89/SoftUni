package MultidimensionalArrays;

import java.io.IOException;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        String[][] matrix = new String[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = sc.nextLine().split("\\s+");
        }

        String input = sc.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");

            if (tokens[0].equals("swap") && tokens.length == 5) {
                int firstRow = Integer.parseInt(tokens[1]);
                int firstCol = Integer.parseInt(tokens[2]);
                int secondRow = Integer.parseInt(tokens[3]);
                int secondCol = Integer.parseInt(tokens[4]);

                if (isInBounds(matrix, firstRow, firstCol)
                        && isInBounds(matrix, secondRow, secondCol)) {
                    String temp = matrix[firstRow][firstCol];
                    matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
                    matrix[secondRow][secondCol] = temp;

                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }


            input = sc.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.print(System.lineSeparator());
        }
    }

    private static boolean isInBounds(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
