import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E05ChangeTownNamesCasing {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.startNewConnection("minions_db");

        PreparedStatement psUpdate = connection.prepareStatement("""
                UPDATE minions_db.towns
                SET name = UPPER(name)
                WHERE country = ?;
                """);

        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();
        psUpdate.setString(1, country);
        psUpdate.executeUpdate();

        PreparedStatement psSelect = connection.prepareStatement("""
                SELECT name
                FROM minions_db.towns
                WHERE country = ?;
                """);
        psSelect.setString(1, country);
        ResultSet resultSet = psSelect.executeQuery();

        List<String> updatedTowns = new ArrayList<>();
        while (resultSet.next()) {
            updatedTowns.add(resultSet.getString("name"));
        }

        if (updatedTowns.isEmpty()) {
            System.out.println("No town names were affected.");
            return;
        }

        System.out.printf("%d town names were affected.%n[%s]", updatedTowns.size(), String.join(", ", updatedTowns));
    }

}
