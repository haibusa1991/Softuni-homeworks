import java.sql.*;
import java.util.Scanner;

public class L01Connecting {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.startNewConnection("soft_uni");

        PreparedStatement ps = connection.prepareStatement("""
                SELECT first_name, last_name
                FROM soft_uni.employees
                WHERE salary > ?
                """);

        Scanner scanner = new Scanner(System.in);
        double targetSalary = Double.parseDouble(scanner.nextLine());
        ps.setDouble(1, targetSalary);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.printf("%s %s%n", rs.getString("first_name"),rs.getString("last_name"));
        }
    }
}
