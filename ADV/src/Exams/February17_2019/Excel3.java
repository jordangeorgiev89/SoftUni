package Exams.February17_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Excel3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );
        int rows = Integer.parseInt(br.readLine());

        String[][] matrix = new String[rows][];

        initializeMatrix(matrix, br);

        String[] tokens = br.readLine().split("\\s+");

        if (tokens[0].equals("hide")) {
            printMatrixWithoutHiddenColumn(matrix, tokens[1]);
        } else if (tokens[0].equals("sort")) {
            sortMatrix(matrix, tokens[1]);
            printMatrix(matrix);
        } else if (tokens[0].equals("filter")) {
            filterMatrix(matrix, tokens[1], tokens[2]);
        }

    }

    private static void filterMatrix(String[][] matrix, String arg1, String arg2) {
        int index = findIndex(matrix, arg1);

        System.out.println(String.join(" | ", matrix[0]));
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][index].equals(arg2)) {
                System.out.println(String.join(" | ", matrix[i]));
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j != matrix[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }

    private static void sortMatrix(String[][] matrix, String sortingValue) {
        int index = findIndex(matrix, sortingValue);

        for (int i = 1; i < matrix.length - 1; i++) {
            if (matrix[i][index].compareTo(matrix[i][index + 1]) > 0) {
                String[] tmp = matrix[i];
                matrix[i] = matrix[i + 1];
                matrix[i + 1] = tmp;
            }
        }
    }

    private static void printMatrixWithoutHiddenColumn(String[][] matrix, String hiddenColumn) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col != findIndex(matrix, hiddenColumn)) {
                    System.out.print(matrix[row][col]);
                    if (col != matrix[row].length - 1) {
                        if (!(col == matrix[row].length - 2 && findIndex(matrix, hiddenColumn) == col + 1)) {
                            System.out.print(" | ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    private static int findIndex(String[][] matrix, String hiddenColumn) {
        int index = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[0][i].equals(hiddenColumn)) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static void initializeMatrix(String[][] matrix, BufferedReader br) throws IOException {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = br.readLine().split(", ");
        }
    }
}
