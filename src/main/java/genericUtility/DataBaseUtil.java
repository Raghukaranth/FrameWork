package genericUtility;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class DataBaseUtil {
    static Connection connection;
    private DataBaseUtil() {
        try {
            Driver driverRef = new Driver();
            DriverManager.registerDriver(driverRef);
        } catch(SQLException e) { e.printStackTrace(); }
    }

    public static Connection createConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        } catch(SQLException e) { e.printStackTrace(); }
        return connection;
    }

    public static String getStatement(int index) throws SQLException {
            Statement statement = connection.createStatement();
            String query = "select * from framework";
            ResultSet result = statement.executeQuery(query);
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet res = meta.getColumns(null, null, "framework", null);
            res.next();
            return res.getString(index);
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
