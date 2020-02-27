package MultidimensionalArrays;//package MultidimensionalArrays;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//
//public class Crossfire {
//        private static final int destroyedCell = Integer.MAX_VALUE;
//        private static List<List<Integer>> matrix = new ArrayList<>();
//    public static void main(String[] args) {
//        public static void main(String[] args) throws IOException {
//
//            Scanner scanner = new Scanner(System.in);
//
//            int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            int rows = dimensions[0];
//            int cols = dimensions[1];
//
//            int fillMatrix = 1;
//            for (int i = 0; i < rows; i++) {
//                matrix.add(new ArrayList<>());
//
//                for (int j = 0; j < cols; j++) {
//                    matrix.get(i).add(fillMatrix++);
//                }
//            }
//            String input;
//            while (!"Nuke it from orbit".equals(input = scanner.nextLine())) {
//
//                int[] commandLine = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
//                int row = commandLine[0];
//                int col = commandLine[1];
//                int range = commandLine[2];
//
//                for (int i = 0; i <= range; i++) {
//
//                    bombExplosion(row, col + i);
//                    bombExplosion(row, col - i);
//                    bombExplosion(row + i, col);
//                    bombExplosion(row - i, col);
//
//                }
//                for (List<Integer> list : matrix) {
//                    list.removeIf(e -> e == destroyedCell);
//
//                }
//                matrix.removeIf(List::isEmpty);
//            }
//            for (List<Integer> list : matrix) {
//                StringBuilder print = new StringBuilder();
//                list.forEach(e -> print.append(e).append(" "));
//                System.out.println(print);
//
//            }
//        }
//        private static void bombExplosion (int row, int col) {
//
//            if (matrix.size() > row && row >= 0) {
//                if (matrix.get(row).size() > col && col >= 0) {
//                    matrix.get(row).set(col, destroyedCell);
//                }
//            }
//
//        }
//    }
//}
