package SetsAndMaps;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        TreeSet<String> elements = new TreeSet<>();

        while (n-- > 0) {
            String[] inputElements = sc.nextLine().split("\\s+");

            elements.addAll(Arrays.asList(inputElements));
        }

        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
