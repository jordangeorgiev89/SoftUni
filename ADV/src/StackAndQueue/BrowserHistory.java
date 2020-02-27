package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BrowserHistory {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );
        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        String url;
        while (!"Home".equals(url = in.readLine())) {
            if (url.equals("back")) {
                if (browserHistory.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    browserHistory.pop();
                    String current = browserHistory.peek();
                    System.out.println(current);
                }
            } else {
                System.out.println(url);
                browserHistory.push(url);
            }
        }
    }
}


