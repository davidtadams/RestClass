package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleJDBCRead {

    public static void main(String[] args) throws Throwable {
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");) {
            Statement statement = conn.createStatement();
            try (ResultSet rs = statement.executeQuery("select * from CUSTOMER");) {
                boolean first = true;
                while (rs.next()) {
                    try {
                        String name = rs.getString("NAME");
                        if (first) {
                            first = false;
                            String broken = rs.getString("BROKEN");
                        }
                        String zip = rs.getString("ZIP");
                        System.out.println(name + " : " + zip);
                    } catch (SQLException sqle) {
                        System.out.println("Internal Problem: " + sqle.getMessage());
                    }
                }
            } catch (SQLException sqle) {
                System.out.println("Problem: " + sqle.getMessage());
            }
        }
    }
}
