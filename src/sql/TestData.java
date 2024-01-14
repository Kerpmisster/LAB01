package sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestData {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Lấy ra đối tượng Connection kết nối vào database.
        Connection conn = ConnectionUtils.getMSSQLConnection();
        // Truy xuất dữ liệu từ bảng
        try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Customer");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int cusID = resultSet.getInt("CusID");
                String cusUser = resultSet.getString("CusUser");
                String cusName = resultSet.getString("CusName");
                String cusPhone = resultSet.getString("CusPhone");
                System.out.println("CusID: " + cusID + ", CusUser: " + cusUser + ", CusName: " + cusName + ", CusPhone: " + cusPhone);
            }
        }

        // Đóng kết nối
        conn.close();
    }
}
