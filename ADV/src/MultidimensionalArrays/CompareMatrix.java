package MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CompareMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );
        int[] dimensions = Arrays.stream(in.readLine().split("\\s++"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstMatrixRows = dimensions[0];
        int firstMatrixCols = dimensions[1];

        int[][] firstMatrix = new int[firstMatrixRows][];

        for (int i = 0; i < firstMatrixRows; i++) {
            int[] arr = Arrays.stream(in.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            firstMatrix[i] = arr;
        }
        dimensions = Arrays.stream(in.readLine().split("\\s++"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int secondMatrixRows = dimensions[0];
        int secondMatrixCols = dimensions[1];

        int[][] secondMatrix = new int[secondMatrixRows][];

        for (int i = 0; i < secondMatrixRows; i++) {
            int[] arr = Arrays.stream(in.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            secondMatrix[i] = arr;
        }

        if (matricesAreEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}

