package ru.job4j.block3.jdbc;

import ru.job4j.block2.io.Config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JbbcStart {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Config cfg = new Config("./src/main/resources/app.properties");
        cfg.load();

        try (Connection connection = DriverManager.getConnection(cfg.value("url"), cfg.value("login"), cfg.value("password"))) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
