package org.hstn.jdbc_examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDelete {
    static final String USER = "jpauser";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM students where id = ?");
            preparedStatement.setLong(1, 4);
            int deletedRows = preparedStatement.executeUpdate();
            System.out.println(deletedRows);

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
