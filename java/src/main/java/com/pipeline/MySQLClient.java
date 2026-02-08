package com.pipeline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLClient {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/TreasuryDB";
        String user = "root";
        String password = ""; // update if you use one

        try {
            // 🔑 Explicitly register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM ExchangeRates");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("currency_pair") + " | " +
                    rs.getDouble("rate")
                );
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}