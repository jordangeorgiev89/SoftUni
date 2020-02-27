package MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int angle = Integer.parseInt(buffer.readLine().replaceAll("[A-Za-z()]+", "")) % 360;
        String input;
        int maxLength = -1;
        List<String> inputLines = new ArrayList<>();

        while (!"END".equals(input = buffer.readLine())) {

            inputLines.add(input);
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
        }
        char[][] matrix = new char[inputLines.size()][maxLength];

        for (int i = 0; i < inputLines.size(); i++) {
            for (int j = 0; j < maxLength; j++) {

                if (j < inputLines.get(i).length()) {
                    matrix[i][j] = inputLines.get(i).charAt(j);
                }else {
                    matrix[i][j] = ' ';
                }
            }
        }
        matrix = matrixRotation(matrix, angle);
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }
    private static char[][] matrixRotation(char[][] matrix, int angle) {

        char[][] rotatedMatrix = new char[matrix[0].length][matrix.length];
        int rows = rotatedMatrix.length;
        int cols = rotatedMatrix[0].length;

        switch (angle) {
            case 90:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        rotatedMatrix[i][j] = matrix[rotatedMatrix[0].length - 1 - j][i];
                    }
                }
                break;
            case 180:
                rotatedMatrix = new char[matrix.length][matrix[0].length];
                rows = rotatedMatrix.length;
                cols = rotatedMatrix[0].length;

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        rotatedMatrix[i][j] = matrix[matrix.length - 1 - i][matrix[0].length - 1 - j];
                    }
                }
                break;
            case 270:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        rotatedMatrix[i][j] = matrix[j][matrix[0].length - 1 - i];
                    }
                }
                break;
            default:
                rotatedMatrix = matrix;
                break;
        }
        return rotatedMatrix;
    }
}
