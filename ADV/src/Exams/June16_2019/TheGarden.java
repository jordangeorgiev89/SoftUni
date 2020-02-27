package Exams.June16_2019;

import java.util.Scanner;

public class TheGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsCount = Integer.parseInt(scanner.nextLine());

        String[][] garden = new String[rowsCount][];
        for (int i = 0; i < rowsCount; i++) {
            garden[i] = scanner.nextLine().split("\\s+");

        }
        int harmed = 0;
        int carrots = 0;
        int potatoes = 0;
        int lettuce = 0;

        String line;
        while (!"End of Harvest".equalsIgnoreCase(line = scanner.nextLine())) {
            String[] tokens = line.split("\\s+");
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            if (row >= 0 && row < rowsCount && col >= 0 && col < garden[row].length) {

                switch (tokens.length) {
                    case 3:

                        if (garden[row][col] != null
                                && !garden[row][col].equals(" ")) {

                            if (garden[row][col].equalsIgnoreCase("c")) {
                                carrots++;
                            } else if (garden[row][col].equalsIgnoreCase("p")) {
                                potatoes++;
                            } else if (garden[row][col].equalsIgnoreCase("l")) {
                                lettuce++;
                            }

                            garden[row][col] = " ";
                        }

                        break;

                    case 4:
                        String command = tokens[3];
                        if (command.equalsIgnoreCase("up")) {

                            for (int i = row; i >= 0; i -= 2) {
                                if (garden[i][col] != null
                                        && !garden[i][col].equals(" ")) {
                                    garden[i][col] = " ";
                                    harmed++;
                                }
                            }

                        } else if (command.equalsIgnoreCase("down")) {
                            for (int i = row; i < rowsCount; i += 2) {
                                if (garden[i][col] != null
                                        && !garden[i][col].equals(" ")) {
                                    garden[i][col] = " ";
                                    harmed++;

                                }

                            }

                        } else if (command.equalsIgnoreCase("left")) {
                            for (int i = col; i >= 0; i -= 2) {
                                if (garden[row][i] != null
                                        && !garden[row][i].equals(" ")) {
                                    garden[row][i] = " ";
                                    harmed++;

                                }
                            }

                        } else if (command.equalsIgnoreCase("right")) {
                            for (int i = col; i < garden[row].length; i += 2) {
                                if (garden[row][i] != null
                                        && !garden[row][i].equals(" ")) {
                                    garden[row][i] = " ";
                                    harmed++;
                                }
                            }
                        }

                        break;

                    default:
                        break;
                }
            }
        }

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < garden[i].length; j++) {
                System.out.print(garden[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(String.format("Carrots: %d", carrots));
        System.out.println(String.format("Potatoes: %d", potatoes));
        System.out.println(String.format("Lettuce: %d", lettuce));
        System.out.println(String.format("Harmed vegetables: %d", harmed));
    }
}
