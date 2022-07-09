import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class E06RemoveVillain {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.startNewConnection("minions_db");


        Scanner scanner = new Scanner(System.in);
        int villainId = Integer.parseInt(scanner.nextLine());

        PreparedStatement deleteFromMappingTable = connection.prepareStatement("""
                DELETE FROM minions_db.minions_villains
                WHERE villain_id = ?;
                """);
        deleteFromMappingTable.setInt(1, villainId);

        PreparedStatement deleteVillain = connection.prepareStatement("""
                DELETE FROM minions_db.villains
                WHERE id = ?;
                """);
        deleteVillain.setInt(1, villainId);

        PreparedStatement getVillainName = connection.prepareStatement("""
                SELECT name
                FROM minions_db.villains
                WHERE id = ?;
                """);
        getVillainName.setInt(1, villainId);
        ResultSet getVillainNameResult = getVillainName.executeQuery();

        if (!getVillainNameResult.next()) {
            System.out.println("No such villain was found");
            return;
        }

        String villainName = getVillainNameResult.getString("name");

        connection.setAutoCommit(false);
        try {
            int releasedMinionsCount = deleteFromMappingTable.executeUpdate();
            deleteVillain.executeUpdate();
            connection.commit();
            System.out.printf("%s was deleted%n%d minions released", villainName, releasedMinionsCount);
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
    }
}
