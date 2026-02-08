package com.pipeline;

import java.sql.*;

public class MySQLClient {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/TreasuryDB";
        String user = "root";
        String password = "";

        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(
            "SELECT currency_pair, rate FROM ExchangeRates ORDER BY id DESC LIMIT 1"
        );

        while (rs.next()) {
            System.out.println("[Java] Latest Rate: " +
                rs.getString("currency_pair") + " = " +
                rs.getDouble("rate"));
        }

        conn.close();
    }
}
