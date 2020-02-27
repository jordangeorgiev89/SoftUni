package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );

        String sequence = in.readLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean areBalanced = true;
        for (int i = 0; i < sequence.length(); i++) {
            char current = sequence.charAt(i);

            if (current == '[' || current == '{' || current == '(') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char topElement = stack.pop();
                if (current == ']' && topElement != '[') {
                    areBalanced = false;
                    break;
                } else if (current == '}' && topElement != '{') {
                    areBalanced = false;
                    break;
                } else if (current == ')' && topElement != '(') {
                    areBalanced = false;
                    break;

                }
            }
        }
        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
