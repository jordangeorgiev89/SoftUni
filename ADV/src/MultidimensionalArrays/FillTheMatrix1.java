package MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix;

        if (pattern.equals("A")) {
            matrix = generateMatrixWithPatternA(size);
        } else {
            matrix = generateMatrixWithPatternB(size);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                System.out.print(matrix[col][row] + " ");
            }
            System.out.println();
        }
    }


    private static int[][] generateMatrixWithPatternA(int size) {
        int[][] matrix = new int[size][size];

        int value = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = value;
                value++;
            }
        }
        return matrix;
    }

    private static int[][] generateMatrixWithPatternB(int size) {
        int[][] matrix = new int[size][size];

        int value = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = value;
                    value++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = value;
                    value++;
                }
            }
        }


        return matrix;
    }
}
