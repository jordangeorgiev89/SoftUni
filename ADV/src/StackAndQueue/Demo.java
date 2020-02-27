package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );
        int n = Integer.parseInt(in.readLine());

        List<Integer> plants = Arrays.stream(in.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true) {
            for (int i = plants.size() - 1; i > 1; i--) {
                if (plants.get(i) > plants.get(i) - 1) {
                    plants.remove(plants.get(i));
                }
            }
            break;
        }
        System.out.println();
    }
}
