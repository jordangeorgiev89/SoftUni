package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] stringNumbers = sc.nextLine().split(", ");

        List<Integer> evenNumbers = Arrays.stream(stringNumbers)
                .map(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

        List<String> numbers = evenNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        String evenNums = String.join(", ", numbers);
        System.out.println(evenNums);


        evenNumbers.sort(Integer::compare);



        List<String> evenSorted = evenNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());




        evenNums = String.join(", ", evenSorted);
        System.out.println(evenNums);


    }
}
