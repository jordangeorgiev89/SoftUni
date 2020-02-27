package Exams.February17_2019;

import java.util.Arrays;
import java.util.Scanner;

public class Excel1 {

    public static int hiddenColumnIndex = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());

        String[][] matrix = new String[rows][];

        initializeMatrixRows(matrix, rows, sc);

        String[] commands = sc.nextLine().split("\\s+");

        if (commands[0].equals("hide")) {
            getColumnIndex(matrix, commands[1]);
            printMatrixWithHiddenColumn(matrix, rows);
        } else if (commands[0].equals("sort")) {
            for (int i = 0; i < matrix[i].length; i++) {
                if (matrix[0][i].equals(commands[1])) {
                    hiddenColumnIndex = i;
                    break;
                }
            }
            System.out.println();
            for (int i = 1; i < matrix.length - 1; i++) {
                if (matrix[i][hiddenColumnIndex].compareTo(matrix[i + 1][hiddenColumnIndex]) > 0) {
                    String[] tmp = matrix[i];
                    matrix[i] = matrix[i + 1];
                    matrix[i + 1] = tmp;
                }
            }
            printMatrix(matrix);
        } else {
            getColumnIndex(matrix, commands[1]);
            filterByColumn(matrix, commands[1], commands[2]);
        }
    }

    private static void filterByColumn(String[][] matrix, String filterColumn, String filterValue) {
        System.out.println(String.join(" | ", matrix[0]));
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][hiddenColumnIndex].equals(filterValue)) {
                System.out.println(String.join(" | ", matrix[i]));
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j != matrix[i].length - 1) {
                    if (!(j == matrix[i].length - 2 && hiddenColumnIndex == j + 1)) {
                        System.out.print(" | ");
                    }
                }
            }
            System.out.println();
        }
    }

    private static void printMatrixWithHiddenColumn(String[][] matrix, int rows) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == hiddenColumnIndex) {
                    continue;
                }
                System.out.print(matrix[i][j]);
                if (j != matrix[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }

    private static void getColumnIndex(String[][] matrix, String thingTohide) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i].equals(thingTohide)) {
                hiddenColumnIndex = i;
                break;
            }
        }
    }

    private static void initializeMatrixRows(String[][] matrix, int rows, Scanner sc) {
        for (int i = 0; i < rows; i++) {
            matrix[i] = sc.nextLine().split(", ");
        }
    }
}
