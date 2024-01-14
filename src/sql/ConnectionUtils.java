package sql;
import java.sql.*;
public class ConnectionUtils {
    public static Connection getMSSQLConnection() throws SQLException {
        String hostName = "LAPTOP-SSHUBNQA"; // Địa chỉ IP hoặc tên máy chủ của SQL Server.
        String sqlInstanceName = "SQLEXPRESS"; // Địa chỉ IP hoặc tên máy chủ của SQL Server.
        String dbName = "CustomerManager"; //Tên cơ sở dữ liệu bạn muốn kết nối.
        String userName = "sa"; //Tên đăng nhập SQL Server.
        String password = "123456"; //Mật khẩu đăng nhập SQL Server.

        String connectionURL = "jdbc:sqlserver://" + hostName + ":1433;instance=" + sqlInstanceName + ";databaseName="+ dbName;
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;

    }
}
