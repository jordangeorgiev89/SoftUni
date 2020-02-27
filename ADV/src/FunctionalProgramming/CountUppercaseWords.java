package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = sc.nextLine().split(" ");

        Predicate<String> isStartingWithCapital = word ->
                Character.isAlphabetic(word.charAt(0)) ?
                        Character.isUpperCase(word.charAt(0)) :
                        Character.isUpperCase(word.charAt(1));

        List<String> capitalWords = Arrays.stream(words)
                .filter(isStartingWithCapital)
                .collect(Collectors.toList());

        System.out.println(capitalWords.size());
        capitalWords.forEach(System.out::println);
    }
}
