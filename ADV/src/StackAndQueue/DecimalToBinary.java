package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class DecimalToBinary {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );
        int number = Integer.valueOf(in.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (number != 0) {
            stack.push(number % 2);
            number /= 2;
        }

        while (!stack.isEmpty())
            System.out.print(stack.pop());

    }
}
