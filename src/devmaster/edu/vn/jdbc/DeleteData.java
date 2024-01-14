package devmaster.edu.vn.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DeleteData {
    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {
// Tạo kết nối
        Connection connection = ConnectionUtils.getMySQLConnection();

// Tạo truy vấn cập nhật
        String sql = "DELETE FROM product WHERE ProID = ? ";
        PreparedStatement pstm = connection.prepareStatement(sql);

// gán giá trị cho biến tham số
        pstm.setInt(1, 3);
// Thực thi câu lệnh truy vấn
        int rowCount = pstm.executeUpdate();
        System.out.println("Đã xóa bản ghi (3): " + rowCount);
    }
}