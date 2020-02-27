package SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );

        Set<String> usernames = new LinkedHashSet<>();

        int n = Integer.parseInt(in.readLine());

        while (n-- > 0) {
            String username = in.readLine();

            usernames.add(username);
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
