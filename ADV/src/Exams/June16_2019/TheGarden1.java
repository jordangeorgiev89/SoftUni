package Exams.June16_2019;

import java.util.Scanner;
import java.util.StringJoiner;

public class TheGarden1 {
    private static  int carrots =0;
    private static  int potatoes = 0;
    private  static  int lettuce = 0;
    private  static  int harmedVegetables  = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][];
        for (int i =0; i < n ; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }


        String line = null;
        while (!"End of Harvest".equalsIgnoreCase(line = scanner.nextLine())) {
            try {
                String[] tokens = line.split("\\s+");
                String command = tokens[0];
                int targetRow = Integer.parseInt(tokens[1]);
                int targetCol = Integer.parseInt(tokens[2]);
                switch (command) {
                    case "Harvest":
                        harvest (targetRow, targetCol, matrix);
                        break;
                    case "Mole":
                        String moleDirection = tokens[3];
                        mole(targetRow, targetCol, moleDirection, matrix);
                        break;
                }

            } catch (Exception e)  {
                continue;
            }
        }

        printTheMatrix (matrix);
        System.out.printf("Carrots: %d\n" +
                "Potatoes: %d\n" +
                "Lettuce: %d\n" +
                "Harmed vegetables: %d\n", carrots, potatoes, lettuce, harmedVegetables);



    }

    private static void printTheMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringJoiner rowOutput = new StringJoiner(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                if(!checkCell(matrix[i][j])) {
                    matrix[i][j] = " ";
                }
                rowOutput.add(matrix[i][j]);
            }
            System.out.println(rowOutput.toString());
        }
    }

    private static void mole(int targetRow, int targetCol, String moleDirection, String[][] matrix) {
        int counter = 0;
        switch (moleDirection) {
            case "up":
                for (int row = targetRow; row >=0; row --) {
                    if (counter %2 ==0 && checkCell(matrix[row][targetCol])) {
                        matrix[row][targetCol] = "M";
                        harmedVegetables++;
                    }
                    counter++;
                }
                break;
            case  "down":
                for (int row = targetRow; row< matrix.length; row++) {
                    if (counter %2 ==0 && checkCell(matrix[row][targetCol])) {
                        matrix[row][targetCol] = "M";
                        harmedVegetables++;
                    }
                    counter++;
                }
                break;
            case "left":
                for (int col = targetCol; col>=0; col--) {
                    if (counter %2  ==0 && checkCell(matrix[targetRow][col])) {
                        matrix[targetRow][col] = "M";
                        harmedVegetables++;
                    }
                    counter++;
                }
                break;
            case "right":
                for (int col = targetCol; col < matrix[targetRow].length; col++) {
                    if (counter %2 ==0 && checkCell(matrix[targetRow][col])){
                        matrix[targetRow][col] = "M";
                        harmedVegetables++;
                    }
                    counter++;
                }
                break;
        }
    }

    private static void harvest(int targetRow, int targetCol, String[][] matrix) {
        if (checkCell(matrix[targetRow][targetCol])){
            switch (matrix[targetRow][targetCol]) {
                case "C": carrots++; break;
                case "L": lettuce++; break;
                case "P": potatoes++;break;
            }
            matrix[targetRow][targetCol] = "H";
        }
    }

    private  static  boolean checkCell (String cellValue) {
        if (cellValue.equalsIgnoreCase("M") || cellValue.equalsIgnoreCase("H")) {
            return  false;
        }
        return  true;
    }

}