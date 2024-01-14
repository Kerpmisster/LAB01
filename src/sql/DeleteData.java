package sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {
    public static void main(String[] args) {
        try {
            // Lấy ra đối tượng Connection kết nối vào database.
            Connection conn = ConnectionUtils.getMSSQLConnection();

            // Nhập mã khách hàng cần xóa từ bàn phím
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập mã khách hàng cần xóa: ");
            int cusID = scanner.nextInt();

            // Kiểm tra xem khách hàng có tồn tại không
            if (isCustomerExist(conn, cusID)) {
                // Nếu tồn tại, thực hiện xóa dữ liệu khách hàng
                deleteCustomer(conn, cusID);
                System.out.println("Đã xóa khách hàng có mã " + cusID);
            } else {
                System.out.println("Không tìm thấy khách hàng với mã " + cusID);
            }

            // Đóng kết nối
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean isCustomerExist(Connection conn, int cusID) throws SQLException {
        try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Customer WHERE CusID = ?")) {
            preparedStatement.setInt(1, cusID);
            return preparedStatement.executeQuery().next();
        }
    }

    private static void deleteCustomer(Connection conn, int cusID) throws SQLException {
        try (PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Customer WHERE CusID = ?")) {
            preparedStatement.setInt(1, cusID);
            preparedStatement.executeUpdate();
        }
    }
}
