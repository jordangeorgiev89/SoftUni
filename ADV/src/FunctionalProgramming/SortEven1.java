package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEven1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", ");

        List<Integer> evens = Arrays.stream(input)
                .map(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

        List<String> nums = evens.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", nums));

        evens.sort(Integer::compare);

        List<String> sorted = evens.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", sorted));
    }
}
