package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTables {

    public static void main(String[] args) {
        String sql =
                "CREATE TABLE IF NOT EXISTS orders (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT, " +
                "product_name TEXT, " +
                "quantity INTEGER, " +
                "total_price DOUBLE" +
                ");";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:db/retail.db");
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Orders table created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
