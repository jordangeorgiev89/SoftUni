package Generics.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        while (!input.equals("END")) {

            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            switch (command) {

            }

            input = sc.nextLine();
        }
    }
}
