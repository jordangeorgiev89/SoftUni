package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );

        int[] input = Arrays.stream(in.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = input[0];
        int s = input[1];
        int x = input[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] elements = Arrays.stream(in.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < n; i++) {
            queue.offer(elements[i]);
        }

        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        if (queue.contains(x)) {
            System.out.println("true");
        } else {
            System.out.println(queue.stream().min(Integer::compareTo).orElse(0));
        }
    }
}

