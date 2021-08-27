package its.nugrohodimas.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection conn;

    public  Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/metrodata", "root", "root"
            );
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error + " + e.getMessage());
        }
        return conn;
    }
}
