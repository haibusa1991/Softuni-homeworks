import java.sql.*;
import java.util.Scanner;

public class E08IncreaseMinionsAge {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.startNewConnection("minions_db");

        Scanner scanner = new Scanner(System.in);
        String minionIds = String.join(", ", scanner.nextLine().split("\\s+"));

        PreparedStatement increaseAgeStatement = connection.prepareStatement("""
                UPDATE minions_db.minions
                SET age = age+1
                WHERE id IN (""" + minionIds + ");");
        increaseAgeStatement.executeUpdate();

        PreparedStatement setNameToLowercaseStatement = connection.prepareStatement("""
                UPDATE minions_db.minions
                SET name = LOWER(name)
                WHERE id in (""" + minionIds + ");");
        setNameToLowercaseStatement.executeUpdate();

        PreparedStatement getMinionsData = connection.prepareStatement("""
                SELECT name, age
                FROM minions_db.minions;
                """);

        ResultSet rs = getMinionsData.executeQuery();
        while (rs.next()) {
            System.out.printf("%s %d%n", rs.getString("name"), rs.getInt("age"));
        }

    }

}
