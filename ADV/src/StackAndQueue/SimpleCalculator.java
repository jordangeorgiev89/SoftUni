package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class SimpleCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );
        String[] input = in.readLine().split("\\s+");

        ArrayDeque<String> tokens = new ArrayDeque<>();

        Collections.addAll(tokens, input);

        while (tokens.size() > 1) {
            int firstNumber = Integer.parseInt(tokens.pop());
            String operator = tokens.pop();
            int secondNumber = Integer.parseInt(tokens.pop());
            int result = 0;

            if (operator.equals("+")) {
                result = firstNumber + secondNumber;
            } else {
                result = firstNumber - secondNumber;
            }
            tokens.push(String.valueOf(result));
        }
        System.out.println(tokens.peek());
    }
}
