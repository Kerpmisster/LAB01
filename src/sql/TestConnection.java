package sql;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {
        System.out.println("Get connection ... ");
        // Lấy ra đối tượng Connection kết nối vào database.
        Connection conn = ConnectionUtils.getMSSQLConnection();
        System.out.println(conn.getCatalog());
        System.out.println("Done!");
    }
}
