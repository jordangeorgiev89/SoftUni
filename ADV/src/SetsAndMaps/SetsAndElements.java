package SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsAndElements {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        LinkedHashSet<Integer> firstNumbers = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondNumbers = new LinkedHashSet<>();


        int n = sc.nextInt();
        int m = sc.nextInt();

        while (n-- > 0) {
            int number = sc.nextInt();
            firstNumbers.add(number);
        }

        while (m-- > 0) {
            int number = sc.nextInt();
            secondNumbers.add(number);
        }

        firstNumbers.retainAll(secondNumbers);

        firstNumbers.forEach(e -> System.out.print(e + " "));
    }
}
