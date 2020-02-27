import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SpaceStation {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bfr.readLine());
        char[][] space = new char[size][];
        int craftRow = 0;
        int craftCol = 0;
        int[] firstBlackHole = new int[2];
        int[] secondBlackHole = new int[2];
        boolean found = false;


        for (int i = 0; i < size; i++) {
            String line = bfr.readLine();
            space[i] = line.toCharArray();
            if (line.contains("S")) {
                craftRow = i;
                craftCol = line.indexOf("S");
            }
            if (line.contains("O")) {
                if (!found) {
                    found = true;
                    firstBlackHole[0] = i;
                    firstBlackHole[1] = line.indexOf("O");
                } else {
                    secondBlackHole[0] = i;
                    secondBlackHole[1] = line.indexOf("O");
                }
            }
        }
        int starPower = 0;
        boolean spaceLost = false;
        String first = String.format("%d %d", firstBlackHole[0], firstBlackHole[1]);
        String second = String.format("%d %d", secondBlackHole[0], secondBlackHole[1]);
        while (starPower < 50) {
            String command = bfr.readLine();
            space[craftRow][craftCol] = '-';
            switch (command) {
                case "up":
                    craftRow--;
                    break;
                case "down":
                    craftRow++;
                    break;
                case "left":
                    craftCol--;
                    break;
                case "right":
                    craftCol++;
                    break;
            }
            if (craftRow < 0 || craftRow >= space.length || craftCol < 0 || craftCol >= space[craftRow].length) {
                spaceLost = true;
                break;
            }
            String coords = String.format("%d %d", craftRow, craftCol);
            if (Character.isDigit(space[craftRow][craftCol])) {
                starPower += Integer.parseInt(String.valueOf(space[craftRow][craftCol]));
                space[craftRow][craftCol] = '-';
            } else if (coords.equals(first) || coords.equals(second)) {
                if (coords.equals(first)) {
                    space[craftRow][craftCol] = '-';
                    craftRow = secondBlackHole[0];
                    craftCol = secondBlackHole[1];
                }else {
                    space[craftRow][craftCol] = '-';
                    craftRow = secondBlackHole[0];
                    craftCol = secondBlackHole[1];
                }
            }
            space[craftRow][craftCol] = 'S';
        }
        if (spaceLost) {
            System.out.println("Bad news, the spaceship went to the void.");
        }else {
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");
        }
        System.out.println(String.format("Star power collected: %d", starPower));
        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[i].length; j++) {
                System.out.print(space[i][j]);
            }
            System.out.println();
        }
    }
}