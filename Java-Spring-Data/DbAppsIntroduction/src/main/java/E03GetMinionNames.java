import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class E03GetMinionNames {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.startNewConnection("minions_db");

        PreparedStatement ps = connection.prepareStatement("""
                SELECT v.name, m.name, m.age
                FROM minions_db.villains v
                JOIN minions_db.minions_villains mv on v.id = mv.villain_id
                JOIN minions_db.minions m on m.id = mv.minion_id
                WHERE v.id=?
                                """);

        Scanner scanner = new Scanner(System.in);
        int targetVillainId = Integer.parseInt(scanner.nextLine());
        ps.setInt(1, targetVillainId);
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            System.out.printf("No villain with ID %d exists in the database.", targetVillainId);
            return;
        }

        System.out.printf("Villain: %s%n", rs.getString("v.name"));

        for (int i = 1; rs.next(); i++) {
            System.out.printf("%d. %s %d%n", i, rs.getString("m.name"), rs.getInt("m.age"));
        }
    }

}
