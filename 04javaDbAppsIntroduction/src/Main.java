import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "minions_db";
    private static Connection connection;
    private static String query;
    private static PreparedStatement statement;
    private static BufferedReader reader;

    public static void main(String[] args) throws SQLException, IOException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "0nceuponatimE9966");

        connection = DriverManager
                .getConnection(CONNECTION_STRING + DATABASE_NAME, properties);

//        2. Get Villains Names
//        getVillainsNamesAndCountOfMinions();
//        3. Get Minions Names
        getMinionNameEx();
//
//        statement = connection.prepareStatement(query);
//
//        ResultSet resultSet = statement.executeQuery();
//        while (resultSet.next()) {
//            System.out.printf("%s %n", resultSet.getString(1));
        }

    private static void getMinionNameEx() throws IOException {
        int villain_id = Integer.parseInt(reader.readLine());

        if (!checkIfEntityExists(villain_id, "villains")) {
            System.out.printf("No villain with ID %s exists in the database.", villain_id);
            return;
        }

        System.out.printf("Villain: %s%%n", );

    }

    private static boolean checkIfEntityExists(int villain_id, String villains) {
        query = "SELECT * FROM " + villains + ""
    }

    private static void getVillainsNamesAndCountOfMinions() throws SQLException {
        query = "SELECT v.name, COUNT(mv.minion_id) AS 'count'\n" +
                "FROM villains AS v\n" +
                "JOIN minions_villains mv on v.id = mv.villain_id\n" +
                "GROUP BY v.name\n" +
                "HAVING `count` > 15\n" +
                "ORDER BY `count` DESC";

        statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString(1),
                    resultSet.getInt(2));
        }
    }
}
