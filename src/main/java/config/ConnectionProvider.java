package config;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
        private static String url = "jdbc:mysql://localhost:3306/bai_thi";
        private static String username = "root";
        private static String pwd = "noot";

        public static java.sql.Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, username, pwd);
        }

    }


