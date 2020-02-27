//package Exams.February17_2019;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Excel {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(
//                new InputStreamReader(
//                        System.in
//                )
//        );
//
//        int n = Integer.parseInt(br.readLine());
//
//        String[][] matrix = new String[n][];
//
//        for (int i = 0; i < n; i++) {
//            matrix[i] = br.readLine().split(", ");
//        }
//
//        String[] tokens = br.readLine().split("\\s+");
//        String command = tokens[0];
//
//        if (command.equals("hide")) {
//            hideMatrixAndPrint(matrix, tokens[1]);
//        } else if (command.equals("sort")) {
//            sortMatrixAndPrint(matrix, tokens[1]);
//        }
//    }
//
//    private static void sortMatrixAndPrint(String[][] matrix, String sortingValue) {
//        System.out.println(String.join(" | ", matrix[0]));
//
//        int index = -1;
//        for (int i = 0; i < matrix[0].length; i++) {
//            if (matrix[0][i].equals(sortingValue)) {
//                index = i;
//                break;
//            }
//        }
//
//        for (int i = 1; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (matrix)
//            }
//        }
//    }
//
//    private static void hideMatrixAndPrint(String[][] matrix, String columnToHide) {
//        int hiddenIndex = -1;
//
//        for (int i = 0; i < matrix[0].length; i++) {
//            if (matrix[0][i].equals(columnToHide)) {
//                hiddenIndex = i;
//                break;
//            }
//        }
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (j == hiddenIndex) {
//                    continue;
//                } else {
//                    System.out.print(matrix[i][j]);
//                    if (j != matrix[i].length - 1) {
//                        if (!(j == matrix[j].length - 2 && hiddenIndex == j + 1)) {
//                        System.out.print(" | ");
//                        }
//                    }
//                }
//            }
//            System.out.println();
//        }
//    }
//}
