package utils;
import java.sql.Connection;

public class DBTest {
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("Connection successful!");
            DBConnection.closeConnection(conn);
        } else {
            System.out.println("Connection failed.");
        }
    }
}
