package sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchData {
    public static void main(String[] args) {
        try {
            // Lấy ra đối tượng Connection kết nối vào database.
            Connection conn = ConnectionUtils.getMSSQLConnection();

            // Nhập tên khách hàng cần tìm kiếm từ bàn phím
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập tên khách hàng cần tìm kiếm: ");
            String searchName = scanner.nextLine();

            // Thực hiện tìm kiếm khách hàng theo CusName
            try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Customer WHERE CusName LIKE ?")) {
                preparedStatement.setString(1, "%" + searchName + "%");
                ResultSet resultSet = preparedStatement.executeQuery();

                // Hiển thị kết quả
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
