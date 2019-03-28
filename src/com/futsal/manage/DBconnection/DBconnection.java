package com.futsal.manage.DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    private Connection connection = null;

    public DBconnection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public Connection open() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/futsal_manage", "root", "");
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
