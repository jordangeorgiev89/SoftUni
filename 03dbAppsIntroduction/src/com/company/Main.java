package com.company;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter username default (root): ");
//        String user = sc.nextLine().trim();
//        user = user.equals("") ? "root" : user;

//        System.out.println("Enter password default (root): ");
//        String password = sc.nextLine().trim();
//        password = password.equals("") ? "0nceuponatimE9966" : password;

//        Properties props = new Properties();
//        props.setProperty("user", user);
//        props.setProperty("password", password);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Driver loaded successfully");

        Connection connection = DriverManager.getConnection("jdbc:mysql://root:0nceuponatimE9966@localhost:3306/soft_uni?useSSL=false");
        System.out.println("Connected successfully");

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employees WHERE salary > ?");

        System.out.println("Enter minimal salary (default 20000):");
        String salaryStr = sc.nextLine().trim();
        double salary = salaryStr.equals("") ? 20000 : Double.parseDouble(salaryStr);

        stmt.setDouble(1, salary);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.printf("| %-15.15s | %-15.15s | %10.2f |\n",
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDouble("salary")
            );
        }
        connection.close();
    }
}
