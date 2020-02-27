package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        ToIntFunction<String> mapper = str -> Integer.parseInt(str);

        int[] sequence = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(mapper)
                .toArray();


        Predicate<Integer> shouldPrint = num -> {
            boolean isPrintable = true;

            for (int element : sequence) {
                if (num % element != 0) {
                    isPrintable = false;
                    break;
                }
            }

            return isPrintable;
        };
        for (int i = 1; i <= n; i++) {
            if (shouldPrint.test((i))) {
                System.out.print(i + " ");
            }

        }
    }
}
