package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDAO {

    public static void insertOrder(String username, String productName, int quantity, double totalPrice) throws Exception {
        String sql = "INSERT INTO orders (username, product_name, quantity, total_price) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, productName);
            ps.setInt(3, quantity);
            ps.setDouble(4, totalPrice);

            ps.executeUpdate();
        }
    }

    public static boolean orderExists(String username, String productName) throws Exception {
        String sql = "SELECT COUNT(*) as cnt FROM orders WHERE username = ? AND product_name = ?";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, productName);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && rs.getInt("cnt") > 0;
            }
        }
    }
}
