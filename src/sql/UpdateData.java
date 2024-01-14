package sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateData {
    public static void main(String[] args) {
        try {
            // Lấy ra đối tượng Connection kết nối vào database.
            Connection conn = ConnectionUtils.getMSSQLConnection();

            // Nhập mã khách hàng cần tìm kiếm từ bàn phím
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập mã khách hàng cần tìm kiếm và cập nhật: ");
            int cusID = scanner.nextInt();

            // Kiểm tra xem khách hàng có tồn tại không
            if (isCustomerExist(conn, cusID)) {
                // Nếu tồn tại, hiển thị thông tin khách hàng
                displayCustomerInfo(conn, cusID);

                // Nhập các thông tin mới cho khách hàng
                scanner.nextLine(); // Đọc dòng trống để đọc chuỗi tiếp theo
                System.out.print("Nhập tên người dùng mới: ");
                String newCusUser = scanner.nextLine();

                System.out.print("Nhập mật khẩu mới: ");
                String newCusPass = scanner.nextLine();

                System.out.print("Nhập họ và tên mới: ");
                String newCusName = scanner.nextLine();

                System.out.print("Nhập số điện thoại mới: ");
                String newCusPhone = scanner.nextLine();

                // Thực hiện cập nhật thông tin khách hàng
                updateCustomerInfo(conn, cusID, newCusUser, newCusPass, newCusName, newCusPhone);
                System.out.println("Đã cập nhật thông tin khách hàng.");
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
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }

    private static void displayCustomerInfo(Connection conn, int cusID) throws SQLException {
        try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Customer WHERE CusID = ?")) {
            preparedStatement.setInt(1, cusID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String cusUser = resultSet.getString("CusUser");
                String cusName = resultSet.getString("CusName");
                String cusPhone = resultSet.getString("CusPhone");
                System.out.println("Thông tin khách hàng:");
                System.out.println("CusID: " + cusID + ", CusUser: " + cusUser + ", CusName: " + cusName + ", CusPhone: " + cusPhone);
            }
        }
    }

    private static void updateCustomerInfo(Connection conn, int cusID, String newCusUser, String newCusPass, String newCusName, String newCusPhone) throws SQLException {
        try (PreparedStatement preparedStatement = conn.prepareStatement("UPDATE Customer SET CusUser = ?, CusPass = ?, CusName = ?, CusPhone = ? WHERE CusID = ?")) {
            preparedStatement.setString(1, newCusUser);
            preparedStatement.setString(2, newCusPass);
            preparedStatement.setString(3, newCusName);
            preparedStatement.setString(4, newCusPhone);
            preparedStatement.setInt(5, cusID);
            preparedStatement.executeUpdate();
        }
    }
}
