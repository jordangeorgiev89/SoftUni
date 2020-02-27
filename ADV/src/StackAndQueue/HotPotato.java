package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class HotPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );
        String[] names = in.readLine().split("\\s+");
        int n = Integer.parseInt(in.readLine());

        ArrayDeque<String> children = new ArrayDeque<>();
        Collections.addAll(children, names);

        while (children.size() > 1) {
            for (int i = 0; i < n - 1; i++) {
                String currentChild = children.poll();
                children.offer(currentChild);
            }
            String child = children.poll();
            System.out.println("Removed " + child);
        }
        String lastChild = children.poll();
        System.out.println("Last is " + lastChild);
    }
}
