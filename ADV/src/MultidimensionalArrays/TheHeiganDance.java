package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double dmgDoneEachTurn = Double.parseDouble(scanner.nextLine());
        double heiganHp = 3000000;
        int playerHp = 18500;
        int[] position = {7, 7};
        String lastSpell = "";
        boolean cloudFlag = false;

        while (heiganHp > 0) {
            if (cloudFlag) {
                playerHp -= 3500;
                cloudFlag = false;
            }
            String[] comand = scanner.nextLine().split("\\s+");
            lastSpell = comand[0];
            int x = Integer.parseInt(comand[1]);
            int y = Integer.parseInt(comand[2]);
            ArrayList<String> hitBox = new ArrayList<>();
            int count = 0;
            GetHitBox(x, y, hitBox, count);
            int dmg = 0;
            switch (lastSpell) {
                case "Eruption":
                    dmg = 6000;
                    playerHp = getPlayerHp(playerHp, position, hitBox, dmg);
                    break;
                case "Cloud":
                    dmg = 3500;
                    playerHp = getPlayerHp(playerHp, position, hitBox, dmg);
                    if (hitBox.contains(String.format("%d,%d", position[0], position[1]))) {
                        cloudFlag = true;
                    }
                    break;
            }
            heiganHp -= dmgDoneEachTurn;
            if (playerHp <= 0) {
                break;
            }
        }
        printResult(heiganHp, playerHp, position, lastSpell);
    }

    private static void GetHitBox(int x, int y, ArrayList<String> hitBox, int count) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (x >= 0 || y >= 0) {
                    hitBox.add(count, String.format("%d,%d", i, j));
                    count++;
                }
            }
        }
    }

    private static Integer getPlayerHp(int playerHp, int[] position, ArrayList<String> hitBox, int dmg) {
        boolean positionFlag = false;
        if (hitBox.contains(String.format("%d,%d", position[0], position[1]))) {
            if (position[0] - 1 >= 0) {
                position[0] -= 1;
                positionFlag = true;
            }
            if (hitBox.contains(String.format("%d,%d", position[0], position[1]))) {
                if (positionFlag) {
                    position[0] += 1;
                    positionFlag = false;
                }
                if (position[1] + 1 <= 14) {
                    position[1] += 1;
                    positionFlag = true;
                }
                if (hitBox.contains(String.format("%d,%d", position[0], position[1]))) {
                    if (positionFlag) {
                        position[1] -= 1;
                        positionFlag = false;
                    }
                    if (position[0] + 1 <= 14) {
                        position[0] += 1;
                        positionFlag = true;
                    }
                    if (hitBox.contains(String.format("%d,%d", position[0], position[1]))) {
                        if (positionFlag) {
                            position[0] -= 1;
                            positionFlag = false;
                        }
                        if (position[1] - 1 >= 0) {
                            position[1] -= 1;
                            positionFlag = true;
                        }
                        if (hitBox.contains(String.format("%d,%d", position[0], position[1]))) {
                            if (positionFlag) {
                                position[1] += 1;
                                positionFlag = false;
                            }
                            playerHp -= dmg;
                        }

                    }
                }
            }
        }
        return playerHp;
    }

    private static void printResult(double heiganHp, double playerHp, int[] position, String lastSpell) {
        if (heiganHp <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f\n", heiganHp);
        }
        if (lastSpell.equals("Cloud")) {
            lastSpell = "Plague Cloud";
        }

        if (playerHp <= 0) {
            System.out.printf("Player: Killed by %s\n", lastSpell);
        } else {
            System.out.printf("Player: %.0f\n", playerHp);
        }
        System.out.printf("Final position: %d, %d\n", position[0], position[1]);
    }
}
