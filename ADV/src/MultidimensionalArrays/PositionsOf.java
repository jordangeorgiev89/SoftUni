package MultidimensionalArrays;//package MultidimensionalArrays;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class PositionsOf {
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(
//                        System.in
//                )
//        );
//        int[] dim = Arrays.stream(in.readLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//        int[][] matrix = new int[dim[0]][dim[1]];
//
//        for (int row = 0; row < matrix.length; row++) {
//            String[] line = in.readLine().split("\\s+");
//
//            for (int col = 0; col < line.length; col++) {
//                int value = Integer.parseInt(line[col]);
//
//            }
//            matrix[row][col] = value;
//        }
//        int searchNumber = Integer.parseInt(in.readLine());
//    }
//
//
//
//    }
//}
