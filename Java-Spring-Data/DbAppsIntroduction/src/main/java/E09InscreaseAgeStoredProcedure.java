import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class E09InscreaseAgeStoredProcedure {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.startNewConnection("minions_db");

        Scanner scanner = new Scanner(System.in);
        int minionId = Integer.parseInt(scanner.nextLine());

        PreparedStatement procedureCall = connection.prepareCall("CALL minions_db.usp_get_older(?)");
        procedureCall.setInt(1, minionId);
        procedureCall.executeQuery();

        PreparedStatement resultStatement = connection.prepareStatement("SELECT m.name, m.age FROM minions_db.minions AS m WHERE m.id=?");
        resultStatement.setInt(1, minionId);
        ResultSet resultSet = resultStatement.executeQuery();

        if (resultSet.next()) {
            System.out.printf("%s %d", resultSet.getString("name"), resultSet.getInt("age"));
        }
    }
}
