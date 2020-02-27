package Alabala;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpaceStationEstablishment3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        String[][] galaxy = new String[size][size];
        int row = 0;
        int col = 0;
        for (int i = 0; i < galaxy.length; i++) {
            galaxy[i] = reader.readLine().split("");
            for (int j = 0; j < galaxy[i].length; j++) {
                if (galaxy[i][j].equals("S")) {
                    row = i;
                    col = j;
                }
            }
        }
        int starPower = 0;
        boolean inside = true;
        while (inside && starPower < 50) {
            String command = reader.readLine().toLowerCase();
            galaxy[row][col] = "-";
            switch (command) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }
            if (row < 0 || row >= galaxy.length ||
                    col < 0 || col >= galaxy.length) {
                System.out.println("Bad news, the spaceship went to the void.");
                inside = false;
            } else {
                String current = galaxy[row][col];
                switch (current) {
                    case "O":
                        boolean isBreak = false;
                        for (int i = 0; i < galaxy.length; i++) {
                            for (int j = 0; j < galaxy[i].length; j++) {
                                if (galaxy[i][j].equals("O") &&
                                        i != row && j != col) {
                                    galaxy[row][col] = "-";
                                    row = i;
                                    col = j;
                                    galaxy[row][col] = "S";
                                    isBreak = true;
                                    break;
                                }
                            }
                            if (isBreak) {
                                break;
                            }
                        }
                        break;
                    case "-":
                        galaxy[row][col] = "S";
                        break;
                    default:
                        int star = Integer.parseInt(current);
                        starPower += star;
                        galaxy[row][col] = "S";
                        break;
                }
            }
        }
        if (starPower >= 50) {
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");
        }
        System.out.printf("Star power collected: %d%n",
                starPower);
        for (String[] str : galaxy) {
            System.out.println(String.join("", str));
        }
    }
}