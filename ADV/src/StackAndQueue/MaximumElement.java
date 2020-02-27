package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );
        int n = Integer.parseInt(in.readLine());

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        while (n-- > 0) {
            String[] tokens = in.readLine().split("\\s+");

            String command = tokens[0];

            switch (command) {
                case "1":
                    int element = Integer.parseInt(tokens[1]);
                    numbers.push(element);
                    break;
                case "2":
                    numbers.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(numbers));
                    break;

            }
        }
    }
}
