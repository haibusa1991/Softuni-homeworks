import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class E02GetVillainsNames {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.startNewConnection("minions_db");

        PreparedStatement ps = connection.prepareStatement("""
                SELECT name, COUNT(DISTINCT minion_id) AS num_minions
                FROM minions_db. villains AS v
                         JOIN minions_db.minions_villains mv on v.id = mv.villain_id
                GROUP BY villain_id
                HAVING num_minions > 15
                ORDER BY num_minions DESC;
                """);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.printf("%s %d", rs.getString("name"), rs.getInt("num_minions"));
        }
    }
}
