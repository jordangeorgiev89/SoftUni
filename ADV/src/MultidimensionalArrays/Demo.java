package MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );
        int[] dimensions = Arrays.stream(in.readLine().split("\\s+"))
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
        System.out.println();
    }
}
