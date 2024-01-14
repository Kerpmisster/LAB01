package devmaster.edu.vn.jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
public class TestQuery {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    // Đọc dữ liệu
        String sql = "Select * from product";
        ResultSet rs = QueryDataUtils.getAll(sql);
    // Duyệt trên kết quả trả về.
        while (rs.next()) {
    // Di chuyển con trỏ xuống bản ghi kế tiếp.

            int proId = rs.getInt(1);
            String proName = rs.getString("ProName");
            int proQty = rs.getInt("ProQty");
            float proPrice = rs.getFloat("ProPrice");
            System.out.println("-------------------------------------");

                    System.out.printf("%-5d",proId);
            System.out.printf("%15s" ,proName);
            System.out.printf("%5d" ,proQty);
            System.out.printf("%10.2f" ,proPrice);
        }
    // Đóng
        rs.close();
    }
}
