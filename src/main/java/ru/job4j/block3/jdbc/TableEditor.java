package ru.job4j.block3.jdbc;

import ru.job4j.block2.io.Config;

import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public TableEditor(Properties properties) throws SQLException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws SQLException {
        connection = DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("login"),
                properties.getProperty("password"));
    }

    public void createTable(String tableName) throws Exception {
        try (Connection connection = this.connection) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "create table if not exists %s ();",
                        tableName
                );
                statement.execute(sql);
            }
        }
    }

    public void dropTable(String tableName) throws SQLException {
        try (Connection connection = this.connection) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "DROP TABLE %s;",
                        tableName
                );
                statement.execute(sql);
            }
        }
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        try (Connection connection = this.connection) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "ALTER TABLE %s ADD %s %s ;",
                        tableName, columnName, type
                );
                statement.execute(sql);
            }
        }
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        try (Connection connection = this.connection) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        " ALTER TABLE %s DROP COLUMN %s;",
                        tableName, columnName
                );
                statement.execute(sql);
            }
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        try (Connection connection = this.connection) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        " ALTER TABLE %s RENAME COLUMN %s TO %s;",
                        tableName, columnName, newColumnName
                );
                statement.execute(sql);
            }
        }
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

}