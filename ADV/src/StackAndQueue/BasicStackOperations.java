package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );
        int[] parameters = Arrays.stream(in.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int elementsCount = parameters[0];
        int countToRemove = parameters[1];
        int lookUpElement = parameters[2];

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        Arrays.stream(in.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(elementsCount)
                .forEach(numbers::push);

        while (countToRemove-- > 0) {
            numbers.pop();
        }

        if (numbers.contains(lookUpElement)) {
            System.out.println("true");
        } else {
            if (numbers.size() == 0) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(numbers));
            }
        }
    }
}
