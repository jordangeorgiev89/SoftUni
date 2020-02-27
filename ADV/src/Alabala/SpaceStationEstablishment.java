//package Alabala;
//
//import java.util.Scanner;
//
//public class SpaceStationEstablishment {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int starPower = 0;
//        int n = Integer.parseInt(sc.nextLine());
//        String[][] matrix = new String[n][n];
//
//        int spaceShipRow = -1;
//        int spaceShipCol = -1;
//
//        int blackHoleInRow = -1;
//        int blackHoleInCol = -1;
//
//        int blackHoleOutRow = -1;
//        int blackHoleOutCol = -1;
//
//        boolean blackHoleIn = false;
//        boolean blackHoleOut = false;
//
//
//        for (int row = 0; row < n; row++) {
//            String line = sc.nextLine();
//            matrix[row] = line.split("");
//
//            for (int col = 0; col < n; col++) {
//                if (line.contains("S") || line.contains("s")) {
//                    spaceShipRow = row;
//                    spaceShipCol = line.indexOf("S");
//                }
//
//                if (!blackHoleIn) {
//                    if (line.contains("O") || line.contains("o")) {
//                        blackHoleInRow = row;
//                        blackHoleInCol = line.indexOf("O");
//                        blackHoleIn = true;
//                    }
//                }
//
//                if (blackHoleIn) {
//                    if (line.contains("O") || line.contains("o")) {
//                        blackHoleOutRow = row;
//                        blackHoleOutCol = line.indexOf("O");
//                        blackHoleOut = true;
//                    }
//                }
//            }
//        }
//        while (starPower < 50) {
//            String direction = sc.nextLine();
//
//            if (direction.equals("up")) {
//                spaceShipRow++;
//
//            } else if (direction.equals("down")) {
//                spaceShipRow--;
//
//            } else if (direction.equals("left")) {
//                spaceShipCol--;
//
//            } else if (direction.equals("right")) {
//                spaceShipCol++;
//
//            }
//
//
//            if (matrix[spaceShipRow][spaceShipCol] == "1") {
//                if ()
//            }
//
//
//        }
//
//
//    }
//}
