package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFibonacci {

    static long[] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );

        int n = Integer.parseInt(in.readLine());

        memory = new long[n + 1];

        System.out.println(fibonacci(n));

    }

    private static long fibonacci(int n) {
        if (n < 2) {
            return 1;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        return memory[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
