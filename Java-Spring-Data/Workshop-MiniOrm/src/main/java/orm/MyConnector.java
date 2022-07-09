package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnector {
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";
    private final static String CONNECTION_TYPE_AND_ADDRESS = "jdbc:mysql://localhost:3306/";
    private Connection connection;
    private static MyConnector instance = null;

    private MyConnector() {

    }

    public static MyConnector getInstance() {
        if (instance == null) {
            instance = new MyConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public Connection setConnection(String databaseName) throws SQLException {
        this.connection = DriverManager.getConnection(CONNECTION_TYPE_AND_ADDRESS + databaseName, USERNAME, PASSWORD);
        return getConnection();
    }
}
