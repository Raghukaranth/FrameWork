package browser;

import com.mysql.jdbc.Driver;

import java.net.URL;
import java.sql.*;

public class DataBaseUtil {
    static Connection connection;
    private DataBaseUtil() throws SQLException {
        Driver driverRef = new Driver();
        DriverManager.registerDriver(driverRef);
    }

    public static Connection createConnection() throws SQLException {
        connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
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

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}
