package com.base.con; /**
 * Created by stepinfo on 23/02/16.
 */

import java.sql.*;

public class JDBCStatementSelectExample {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "stepinfo";

    public static void main(String[] argv) {

        try {

            selectRecordsFromDbUserTable();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    private static void selectRecordsFromDbUserTable() throws SQLException {

        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "SELECT category_id, category_name from category";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            System.out.println(selectTableSQL);

            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {

                String userid = rs.getString("category_id");
                String username = rs.getString("category_name");

                System.out.println("userid : " + userid);
                System.out.println("username : " + username);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                    DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {



            System.out.println(e.getMessage());

        }

        return dbConnection;

    }
}
