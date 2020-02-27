package Exams.February24_2019;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ClubPart1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hallCapacity = Integer.parseInt(sc.nextLine());

        String[] input = sc.nextLine().split("\\s+");

        Deque<String> hallsAndReservations = initializeStack(input, hallCapacity);

        Deque<String> halls = new ArrayDeque<>();
        Deque<Integer> currentHallReservations = new ArrayDeque<>();
        int currentHallCapacity = 0;

        while (!hallsAndReservations.isEmpty()) {
            String currentElement = hallsAndReservations.pop();

            if (Character.isDigit(currentElement.charAt(0))) {
                int reservation = Integer.parseInt(currentElement);

                if (currentHallCapacity + reservation > hallCapacity) {
                    printHall(halls, currentHallReservations);
                    currentHallCapacity = 0;
                }

                if (halls.isEmpty()) {
                    continue;
                }

                currentHallCapacity += reservation;
                currentHallReservations.add(reservation);
            } else {
                halls.add(currentElement);
            }
        }


        System.out.println(hallsAndReservations.pop());
    }

    private static void printHall(Deque<String> halls, Deque<Integer> currentHallReservations) {
        System.out.print(halls.remove() + " -> ");

        while (!currentHallReservations.isEmpty()) {
            if (currentHallReservations.size() == 1) {
                System.out.print(currentHallReservations.remove());
            } else {
                System.out.print(currentHallReservations.remove() + ", ");
            }
        }
        System.out.println();
    }

    private static Deque<String> initializeStack(String[] input, int hallCapacity) {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
        }
        return stack;
    }
}
