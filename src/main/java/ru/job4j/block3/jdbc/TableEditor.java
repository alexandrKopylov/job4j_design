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
        String sql = String.format(
                " CREATE TABLE IF NOT EXISTS %s ();",
                tableName
        );
        statementExecute(sql);
    }

    public void dropTable(String tableName) throws SQLException {
        String sql = String.format(
                "DROP TABLE if  exists %s;",
                tableName
        );
        statementExecute(sql);
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        String sql = String.format(
                "ALTER TABLE %s ADD COLUMN if not exists %s %s ;",
                tableName, columnName, type
        );
        statementExecute(sql);
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        String sql = String.format(
                " ALTER TABLE %s DROP COLUMN if  exists %s;",
                tableName, columnName
        );
        statementExecute(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        String sql = String.format(
                " ALTER TABLE %s RENAME COLUMN  %s TO %s  ;",
                tableName, columnName, newColumnName
        );
        statementExecute(sql);
    }

    private void statementExecute(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
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

    public static void main(String[] args) throws Exception {
        Config cfg = new Config("./src/main/resources/app.properties");
        cfg.load();
        Properties properties = new Properties();
        properties.setProperty("url", cfg.value("url"));
        properties.setProperty("login", cfg.value("login"));
        properties.setProperty("password", cfg.value("password"));

        TableEditor te = new TableEditor(properties);
        te.createTable("table1");
        te.createTable("table2");
        te.dropTable("table2");
        te.addColumn("table1", "column1", "varchar(100)");
        te.addColumn("table1", "column2", "varchar(100)");
        te.addColumn("table1", "column3", "varchar(100)");
        te.dropColumn("table1", "column3");
        te.renameColumn("table1", "column2", "колонка2");

        System.out.println(TableEditor.getTableScheme(te.connection, "table1"));
        te.close();

    }
}