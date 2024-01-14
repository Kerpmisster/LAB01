package sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) {
        try {
            // Lấy ra đối tượng Connection kết nối vào database.
            Connection conn = ConnectionUtils.getMSSQLConnection();

            // Nhập dữ liệu từ bàn phím
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập thông tin khách hàng mới:");

            System.out.print("Tên người dùng: ");
            String cusUser = scanner.nextLine();

            System.out.print("Mật khẩu: ");
            String cusPass = scanner.nextLine();

            System.out.print("Họ và tên: ");
            String cusName = scanner.nextLine();

            System.out.print("Số điện thoại: ");
            String cusPhone = scanner.nextLine();

            System.out.print("Địa chỉ: ");
            String cusAdd = scanner.nextLine();

            System.out.print("Email: ");
            String cusEmail = scanner.nextLine();

            System.out.print("Facebook: ");
            String cusFacebook = scanner.nextLine();

            System.out.print("Skype: ");
            String cusSkyper = scanner.nextLine();

            System.out.print("Trạng thái (1 hoặc 0): ");
            int cusStatus = scanner.nextInt();

            // Thực hiện thêm mới khách hàng vào bảng
            try (PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Customer (CusUser, CusPass, CusName, CusPhone, CusAdd, CusEmail, CusFacebook, CusSkyper, CusStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                preparedStatement.setString(1, cusUser);
                preparedStatement.setString(2, cusPass);
                preparedStatement.setString(3, cusName);
                preparedStatement.setString(4, cusPhone);
                preparedStatement.setString(5, cusAdd);
                preparedStatement.setString(6, cusEmail);
                preparedStatement.setString(7, cusFacebook);
                preparedStatement.setString(8, cusSkyper);
                preparedStatement.setInt(9, cusStatus);

                int affectedRows = preparedStatement.executeUpdate();
                System.out.println("Đã thêm " + affectedRows + " khách hàng mới.");
            }

            // Đóng kết nối
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
