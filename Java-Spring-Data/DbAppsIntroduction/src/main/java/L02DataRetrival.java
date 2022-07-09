import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class L02DataRetrival {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.startNewConnection("diablo");


        PreparedStatement ps = connection.prepareStatement("""
                SELECT u.user_name, u.first_name, u.last_name, COUNT(*) AS num_games
                FROM diablo.users AS u
                         JOIN diablo.users_games AS ug ON u.id = ug.user_id
                WHERE u.user_name = ?
                GROUP BY u.id;
                """);

        ps.setString(1, new Scanner(System.in).nextLine());

        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            System.out.println("No such user exists");
            return;
        }

        System.out.printf("User: %s%n%s %s has played %d games",
                rs.getString("user_name"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getInt("num_games"));
    }

}
