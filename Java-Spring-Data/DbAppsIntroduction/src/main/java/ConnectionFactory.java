import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class ConnectionFactory {
    private final static String DB_USERNAME = "root";
    private final static String DB_PASSWORD = "";
    private final static String JDBC = "jdbc:mysql://localhost:3306/";

    public static Connection startNewConnection(String databaseName) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", DB_USERNAME);
        properties.setProperty("password", DB_PASSWORD);
        String connectionLink = JDBC + databaseName;

        return DriverManager.getConnection(connectionLink,properties);
    }
}
