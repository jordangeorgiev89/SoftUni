package MultidimensionalArrays;

import java.util.Scanner;

public class TheHeiganDance2 {
    private static int[][] field = new int[15][15];
    private static int playerRow = 7;
    private static int playerCol = 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double damage = Double.parseDouble(sc.nextLine());

        double playerHealth = 18500;
        double bossHealth = 3000000;

        while (playerHealth > 0 && bossHealth > 0) {
            String[] tokens = sc.nextLine().split("\\s+");

            String spell = tokens[0];
            int targetRow = Integer.parseInt(tokens[1]);
            int targetCol = Integer.parseInt(tokens[2]);

            boolean isHit = checkCell(targetRow, targetCol);

            if (isHit) {
                boolean hasMoved = movePlayer(targetRow, targetCol);
                System.out.println(hasMoved);
                if (spell.equals("Cloud")) {

                } else {

                }
            }
        }

        System.out.printf("Final position: %d, %d", playerRow, playerCol);
    }

    private static boolean movePlayer(int targetRow, int targetCol) {
        if (targetRow == playerRow && targetCol == playerCol) {
            return false;
        }
        boolean hasMoved = false;
        if (isInRange(playerRow - 1, playerCol) && canMove(targetRow, targetCol, playerRow - 1, playerCol)) {
            playerRow--;
            hasMoved = true;
        }
        return hasMoved;
    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < 15 && c >= 0 && c < 15;
    }

    private static boolean canMove(int targetRow, int targetCol, int newRow, int newCol) {
        return newRow < targetRow - 1 || newRow > targetRow + 1
                || newCol < targetCol - 1 || newCol > targetCol + 1;
    }

    private static boolean checkCell(int targetRow, int targetCol) {
        return playerRow >= targetRow - 1 && playerRow <= targetRow + 1
                && playerCol >= targetCol - 1 && playerCol <= targetCol + 1;
    }
}
