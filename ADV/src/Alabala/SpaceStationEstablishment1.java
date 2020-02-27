package Alabala;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SpaceStationEstablishment1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        List<List<String>> matrix = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            matrix.add(Arrays.stream(scanner.nextLine()
                    .split("")).collect(Collectors.toList()));
        }

        int playerRowPosition = 0;
        int playerColumnPosition = 0;

        for (int i = 0; i < rows; i++) {
            if (matrix.get(i).contains("S")) {
                playerRowPosition = i;
                playerColumnPosition = matrix.get(i).indexOf("S");
                break;
            }
        }
        matrix.get(playerRowPosition).set(playerColumnPosition, "-");
        int starPower = 0;

        while (true) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    playerRowPosition--;
                    break;

                case "down":
                    playerRowPosition++;
                    break;

                case "left":
                    playerColumnPosition--;
                    break;

                case "right":
                    playerColumnPosition++;
                    break;
            }

            if (playerRowPosition < 0 || playerColumnPosition < 0 ||
                    playerRowPosition >= rows ||playerColumnPosition >= rows) {

                System.out.println("Bad news, the spaceship went to the void.");
                break;
            }

            if (Character.isDigit(matrix.get(playerRowPosition)
                    .get(playerColumnPosition).charAt(0))) {

                starPower += Integer.parseInt(matrix.get(playerRowPosition)
                        .get(playerColumnPosition));

                matrix.get(playerRowPosition).set(playerColumnPosition, "-");

                if (starPower >= 50) {
                    matrix.get(playerRowPosition).set(playerColumnPosition, "S");
                    System.out.println("Good news! " +
                            "Stephen succeeded in collecting enough star power!");
                    break;
                }
            }
            else if (matrix.get(playerRowPosition)
                    .get(playerColumnPosition).equals("O")) {

                matrix.get(playerRowPosition).set(playerColumnPosition, "-");
                for (int i = 0; i < rows; i++) {
                    if (matrix.get(i).contains("O")) {
                        playerRowPosition = i;
                        playerColumnPosition = matrix.get(i).indexOf("O");
                        matrix.get(playerRowPosition).set(playerColumnPosition, "-");
                        break;
                    }
                }
            }
        }

        System.out.println(String.format("Star power collected: %d", starPower));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(matrix.get(i).get(j));
            }
            System.out.println();
        }
    }
}