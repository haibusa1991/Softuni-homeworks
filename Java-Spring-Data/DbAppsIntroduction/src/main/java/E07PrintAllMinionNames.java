import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class E07PrintAllMinionNames {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.startNewConnection("minions_db");

        PreparedStatement ps = connection.prepareStatement("""
                SELECT name
                FROM minions_db.minions;
                """);
        ResultSet resultSet = ps.executeQuery();

        List<String> names = new ArrayList<>();
        while (resultSet.next()) {
            names.add(resultSet.getString("name"));
        }

        int namesListMiddle = names.size() / 2 + 1;

        if (names.size() % 2 == 0) {
            namesListMiddle = names.size() / 2;
        }

        for (int i = 0; i < namesListMiddle; i++) {
            int backwardsPos = names.size() - 1 - i;

            System.out.println(names.get(i));
            if (i == backwardsPos) {
                break;
            }
            System.out.println(names.get(backwardsPos));
        }
    }
}
