package Exams.April16_2019;

import java.util.Scanner;

public class HelensAbduction {

    public static int energy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        energy = Integer.parseInt(sc.nextLine());

        int rows = Integer.parseInt(sc.nextLine());

        char[][] field = new char[rows][];

        int parisRow = 0;
        int parisCol = 0;
        int helenaRow = 0;
        int helenaCol = 0;

        for (int i = 0; i < rows; i++) {
            String line = sc.nextLine();
            field[i] = line.toCharArray();

            if (line.contains("P")) {
                parisRow = i;
                parisCol = line.indexOf("P");
            } else if (line.contains("H")) {
                helenaRow = i;
                helenaCol = line.indexOf("H");
            }
        }

        boolean isAbducted = false;

        while (energy > 0 && !isAbducted) {
            energy--;

            String direction = sc.next();
            int row = sc.nextInt();
            int col = sc.nextInt();

            field[row][col] = 'S';
            field[parisRow][parisCol] = '-';

            if (direction.equals("up") && canMove(parisRow - 1, parisCol, field)) {
                parisRow--;
                isAbducted = moveParis(parisRow, parisCol, field);

            } else if (direction.equals("down") && canMove(parisRow + 1, parisCol, field)) {
                parisRow++;
                isAbducted = moveParis(parisRow, parisCol, field);

            } else if (direction.equals("left") && canMove(parisRow, parisCol - 1, field)) {
                parisCol--;
                isAbducted = moveParis(parisRow, parisCol, field);

            } else if (direction.equals("right") && canMove(parisRow, parisCol + 1, field)) {
                parisCol++;
                isAbducted = moveParis(parisRow, parisCol, field);

            }
            field[parisRow][parisCol] = 'P';

        }

        if (isAbducted) {
            field[parisRow][parisCol] = '-';
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
        } else {
            field[parisRow][parisCol] = 'X';
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        }
        printField(field);
    }

    public static boolean moveParis(int newRow, int newCol, char[][] field) {
        boolean isAbducted = false;
        if (field[newRow][newCol] == 'S') {
            energy -= 2;
        } else if (field[newRow][newCol] == 'H') {
            isAbducted = true;
        }

        return isAbducted;

    }

    private static boolean canMove(int newRow, int newCol, char[][] field) {
        return newRow >= 0 && newRow < field.length && newCol >= 0 && newCol < field[newRow].length;
    }

    private static void printField(char[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }
}
