package ru.job4j.block2.io;


import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenLegalFile() {
        String path = "app.properties";
        ru.job4j.block2.io.Config config = new ru.job4j.block2.io.Config(path);
       // Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("hibernate.connection.url"), is("jdbc:postgresql://127.0.0.1:5432/trackstudio"));
        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotKey() {
        String path = "app1.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotValue() {
        String path = "app2.properties";
        Config config = new Config(path);
        config.load();
    }
}
