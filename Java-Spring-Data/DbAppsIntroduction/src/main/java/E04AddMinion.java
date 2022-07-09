import jdk.jshell.spi.ExecutionControl.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class E04AddMinion {

    public static void main(String[] args) throws SQLException, NotImplementedException {
        Connection connection = ConnectionFactory.startNewConnection("minions_db");

        Scanner scanner = new Scanner(System.in);

        Minion minion = getMinionFromConsole(scanner);
        String villainName = scanner.nextLine().split(" ")[1];

        if (addIfAbsent(minion.getTown(), "towns", connection)) {
            System.out.printf("Town %s was added to the database.%n", minion.getTown());
        }

        if (addIfAbsent(villainName, "villains", connection)) {
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }

        addMinionToDb(minion, connection);
        connectMinionToVillain(minion, villainName, connection);
        System.out.printf("Successfully added %s to be minion of %s.%n", minion.getName(), villainName);
    }

    private static Minion getMinionFromConsole(Scanner scanner) {
        String[] minionData = scanner.nextLine().split(" ");
        String minionName = minionData[1];
        int minionAge = Integer.parseInt(minionData[2]);
        String minionTown = minionData[3];

        return new Minion(minionName, minionAge, minionTown);
    }

    private static boolean addIfAbsent(String value, String tableName, Connection connection) throws SQLException, NotImplementedException {
        String statementString = "";

        switch (tableName) {
            case "villains":
                statementString = """
                        SELECT *
                        FROM minions_db.villains
                        WHERE name = ?
                        """;
                break;
            case "towns":
                statementString = """
                        SELECT *
                        FROM minions_db.towns
                        WHERE name = ?
                        """;
                break;
            default:
                throw new NotImplementedException("Table not supported");
        }

        PreparedStatement checkIfAbsentStatement = connection.prepareStatement(statementString);
        checkIfAbsentStatement.setString(1, value);
        ResultSet checkIfAbsentResults = checkIfAbsentStatement.executeQuery();
        if (checkIfAbsentResults.next()) {
            return false;
        }

        PreparedStatement ps;

        switch (tableName) {
            case "villains":
                ps = connection.prepareStatement("""
                        INSERT INTO minions_db.villains (name, evilness_factor)
                        VALUES (?, 'evil');
                                                """);
                ps.setString(1, value);
                break;
            case "towns":
                ps = connection.prepareStatement("""
                        INSERT INTO minions_db.towns(name)
                        VALUES (?);
                        """);
                ps.setString(1, value);
                break;
            default:
                throw new NotImplementedException("Table not supported");
        }

        ps.executeUpdate();
        return true;
    }

    private static void addMinionToDb(Minion minion, Connection connection) throws SQLException {

        PreparedStatement getTownIdStatement = connection.prepareStatement("""
                SELECT id
                FROM minions_db.towns
                WHERE name=?;
                """);
        getTownIdStatement.setString(1, minion.getTown());
        ResultSet getTownIdResults = getTownIdStatement.executeQuery();
        getTownIdResults.next();
        int townId = getTownIdResults.getInt("id");


        PreparedStatement ps = connection.prepareStatement("""
                INSERT INTO minions_db.minions(name, age, town_id)
                VALUES (?, ?, ?);
                """);

        ps.setString(1, minion.getName());
        ps.setInt(2, minion.getAge());
        ps.setInt(3, townId);

        ps.executeUpdate();

    }

    private static void connectMinionToVillain(Minion minion, String villainName, Connection connection) throws SQLException {
        PreparedStatement getVillainIdStatement = connection.prepareStatement("""
                SELECT id
                FROM minions_db.villains
                WHERE name = ?;
                """);

        getVillainIdStatement.setString(1, villainName);
        ResultSet villainIdResultSet = getVillainIdStatement.executeQuery();
        villainIdResultSet.next();
        int villainId = villainIdResultSet.getInt("id");

        PreparedStatement getMinionIdStatement = connection.prepareStatement("""
                SELECT id
                FROM minions_db.minions
                WHERE name=? AND age=?;
                """);

        getMinionIdStatement.setString(1, minion.getName());
        getMinionIdStatement.setInt(2, minion.getAge());
        ResultSet minionIdResultSet = getMinionIdStatement.executeQuery();
        minionIdResultSet.next();
        int minionId = minionIdResultSet.getInt("id");

        PreparedStatement ps = connection.prepareStatement("""
                INSERT INTO minions_db.minions_villains (minion_id, villain_id)
                 VALUES(?, ?);
                """);
        ps.setInt(1, minionId);
        ps.setInt(2, villainId);
        ps.executeUpdate();
    }


}
