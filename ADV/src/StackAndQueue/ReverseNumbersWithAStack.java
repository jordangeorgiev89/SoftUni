package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );
        ArrayDeque<String> stack = new ArrayDeque<>();

        Arrays.stream(in.readLine().split("\\s+"))
                .forEach(element -> stack.push(element));

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
