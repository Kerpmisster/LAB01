package devmaster.edu.vn.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class InsertData {
    public static void main(String[] args)  throws ClassNotFoundException, SQLException {
        // Tạo kết nối
        Connection connection = ConnectionUtils.getMySQLConnection();

        Statement statement = connection.createStatement();

        // Tạo truy vấn thêm
        String sql = "INSERT INTO product(ProID,ProName,ProQty,ProPrice) ";

        sql += "VALUES(2,'HP Pavilion dv6609wm - BTO',120,2200)";

        // Thực thi câu lệnh truy vấn
        int rowCount = statement.executeUpdate(sql);
        System.out.println("Đã thêm mới 1 bản ghi: " + rowCount);
    }
}