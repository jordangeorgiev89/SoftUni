package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Consumer<String> printer = System.out::println;

        Arrays.stream(sc.nextLine().split("\\s+"))
                .forEach(printer);
    }
}
