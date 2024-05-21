package org.davidkhala;

import java.sql.*;

public class Raw {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection connection;
    private final String password;
    private final String username;
    private final String connectionString;
    private Statement statement;

    public Raw(String connectionString, String username, String password) throws ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        if (username == null || username.isEmpty()) {
            username = "root";
        }
        this.username = username;
        this.password = password;
        this.connectionString = connectionString;

    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:" + connectionString, username, password);
        statement = connection.createStatement();
    }

    public ResultSet query(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void disconnect() throws SQLException {
        statement.close();
        connection.close();
    }
}

