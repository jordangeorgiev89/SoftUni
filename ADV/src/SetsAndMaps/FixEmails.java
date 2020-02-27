package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();

        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        while (!"stop".equalsIgnoreCase(name)) {
            String email = sc.nextLine();

            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emails.putIfAbsent(email, name);

            }


            name = sc.nextLine();
        }

        for (Map.Entry<String, String> entry : emails.entrySet()) {
            System.out.println(String.format("%s -> %s", entry.getValue(), entry.getKey()));
        }
    }
}
