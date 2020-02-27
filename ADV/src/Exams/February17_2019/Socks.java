package Exams.February17_2019;

import java.util.*;

public class Socks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> leftSocks = new ArrayDeque<>();
        ArrayDeque<Integer> rightSocks = new ArrayDeque<>();

        //stack - push, pop
        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(leftSocks::push);

        //quque - offer, poll
        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(rightSocks::offer);


        List<Integer> pairs = new ArrayList<>();
        while (leftSocks.size() > 0 && rightSocks.size() > 0) {
            int leftSock = leftSocks.peek();
            int rightSock = rightSocks.peek();

            if (leftSock > rightSock) {
                leftSocks.pop();
                rightSocks.poll();
                pairs.add(leftSock + rightSock);
            } else if (rightSock > leftSock) {
                leftSocks.pop();
            } else {
                rightSocks.poll();
                leftSocks.pop();
                leftSocks.push(leftSock + 1);
            }
        }
        int maxPair = pairs.stream().max((t, o) -> t - o).get();

        System.out.println(maxPair);

        pairs.forEach(p -> System.out.print(p + " "));
    }
}
