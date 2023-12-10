package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String select_sql = "SELECT * FROM stores";

        // This will load the Postgres driver, each DB has its own driver
//        Class.forName("com.mysql.jdbc.Driver");
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "docker");
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(select_sql);
        System.out.println("Table 'stores':");
        while (rs.next()){
            System.out.println(rs.getString("store_id") + " " + rs.getString(2));
        }

        connection.close();
    }
}
