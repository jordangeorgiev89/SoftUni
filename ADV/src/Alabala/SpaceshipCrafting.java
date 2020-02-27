package Alabala;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class SpaceshipCrafting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int glassses = 0;
        int aluminums = 0;
        int lithiums = 0;
        int carbonFbibers = 0;

        int glass = 25;
        int aluminum = 50;
        int lithium = 75;
        int carbonFiber = 100;

        boolean glassObtained = false;
        boolean aluminiumObtained = false;
        boolean lithiumObtained = false;
        boolean carbonFiberObtained = false;

        Deque<Integer> chemicalLiquids = new ArrayDeque<>();
        Deque<Integer> physicalItems = new ArrayDeque<>();

        //quque - offer, poll
        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(chemicalLiquids::offer);

        //stack - push, pop
        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(physicalItems::push);

        while (chemicalLiquids.size() > 0 && physicalItems.size() > 0) {
            int liquid = chemicalLiquids.peek();
            int item = physicalItems.peek();

            if (liquid + item == 25) {
                chemicalLiquids.poll();
                physicalItems.pop();
                glassObtained = true;
                glassses++;

            } else if (liquid + item == 50) {
                chemicalLiquids.poll();
                physicalItems.pop();
                aluminiumObtained = true;
                aluminums++;

            } else if (liquid + item == 75) {
                chemicalLiquids.poll();
                physicalItems.pop();
                lithiumObtained = true;
                lithiums++;

            } else if (liquid + item == 100) {
                chemicalLiquids.poll();
                physicalItems.pop();
                carbonFiberObtained = true;
                carbonFbibers++;

            } else {
                chemicalLiquids.poll();
                physicalItems.pop();
                physicalItems.push(item + 3);
            }
        }


        if (glassObtained && aluminiumObtained && lithiumObtained && carbonFiberObtained) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }

        if (chemicalLiquids.size() > 0) {
            System.out.print("Liquids left: ");
            while (chemicalLiquids.size() > 0) {
                System.out.print(chemicalLiquids.poll());
                if (chemicalLiquids.size() >= 1) {
                System.out.print(", ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Liquids left: none");
        }

        if (physicalItems.size() > 0) {
            System.out.print("Physical items left: ");
            while (physicalItems.size() > 0) {
                System.out.print(physicalItems.poll());
                if (physicalItems.size() >= 1) {
                System.out.print(", ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Physical items left: none");
        }

        System.out.printf("Aluminium: %d%n", aluminums);
        System.out.printf("Carbon fiber: %d%n", carbonFbibers);
        System.out.printf("Glass: %d%n", glassses);
        System.out.printf("Lithium: %d%n", lithiums);
    }
}
