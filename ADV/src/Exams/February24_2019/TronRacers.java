package Exams.February24_2019;

import java.util.Scanner;

public class TronRacers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int rowF = 0;
        int colF = 0;
        int rowS = 0;
        int colS = 0;
        String[][] field = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("");
            for (int i1 = 0; i1 < n; i1++) {

                if (line[i1].equalsIgnoreCase("f")) {
                    rowF = i;
                    colF = i1;
                }

                if (line[i1].equalsIgnoreCase("s")) {
                    rowS = i;
                    colS = i1;
                }

                field[i][i1] = line[i1];

            }

        }

        if (field != null) {
            while (true) {
                String[] tokens = scanner.nextLine().split("\\s+");

                String cmd1 = tokens[0];
                String cmd2 = tokens[1];

                if (field[rowF][colF].equalsIgnoreCase("f")) {
                    if (cmd1.equalsIgnoreCase("up")) {
                        rowF = getRowUp(n, rowF);
                    } else if (cmd1.equalsIgnoreCase("down")) {
                        rowF = getRowDown(n, rowF);
                    } else if (cmd1.equalsIgnoreCase("left")) {
                        colF = getColLeft(n, colF);
                    } else if (cmd1.equalsIgnoreCase("right")){
                        colF = getColRight(n, colF);
                    }

                    if (field[rowF][colF].equalsIgnoreCase("s")) {
                        field[rowF][colF] = "x";
                        printField(field);
                        return;
                    }

                    field[rowF][colF] = "f";
                }

                if (field[rowS][colS].equalsIgnoreCase("s")) {
                    if (cmd2.equalsIgnoreCase("up")) {
                        rowS = getRowUp(n, rowS);

                    } else if (cmd2.equalsIgnoreCase("down")) {
                        rowS = getRowDown(n, rowS);

                    } else if (cmd2.equalsIgnoreCase("left")) {
                        colS = getColLeft(n, colS);
                    } else if (cmd2.equalsIgnoreCase("right")){
                        colS = getColRight(n, colS);
                    }

                    if (field[rowS][colS].equalsIgnoreCase("f")) {
                        field[rowS][colS] = "x";
                        printField(field);
                        return;
                    }

                    field[rowS][colS] = "s";
                }

            }
        }

    }

    private static int getColRight(int n, int colF) {
        if (colF + 1 < n) {
            colF++;

        } else {
            colF = 0;
        }
        return colF;
    }

    private static int getColLeft(int n, int colF) {
        if (colF - 1 >= 0) {
            colF--;

        } else {
            colF = n - 1;
        }
        return colF;
    }

    private static int getRowDown(int n, int rowS) {
        rowS = getColRight(n, rowS);
        return rowS;
    }

    private static int getRowUp(int n, int rowF) {
        if (rowF - 1 >= 0) {
            rowF--;

        } else {
            rowF = n - 1;
        }
        return rowF;
    }


    private static void printField(String[][] field) {

        for (String[] strings : field) {
            for (int i1 = 0; i1 < field[0].length; i1++) {
                System.out.print((strings[i1]));
            }
            System.out.println();
        }
    }
}
