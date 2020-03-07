package demo;

import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username default (root): ");
        String user = sc.nextLine().trim();
        user = user.equals("") ? "root": user;

        System.out.println("Enter password default (root): ");
        String password = sc.nextLine().trim();
        password = password.equals("") ? "password": user;

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
