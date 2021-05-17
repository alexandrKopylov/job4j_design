package ru.job4j.BLOCK2.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();
    private static Pattern notKey = Pattern.compile("\\s*=.*");
    private static Pattern notValue = Pattern.compile(".*=\\s*");

    public Config(final String path) {
        this.path = path;
    }


    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines()
                    .filter(Config::stringsFilter)
                    .forEach(s -> values.put(s.substring(0, s.indexOf("=")), s.substring(s.indexOf("=") + 1))
                    );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static boolean stringsFilter(String str) {
        if (str.isEmpty() || str.startsWith("#")) {
            return false;
        }
        if (!str.contains("=") || notKey.matcher(str).matches() || notValue.matcher(str).matches()) {
            throw new IllegalArgumentException();
        }
        return true;
    }


    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }


    public static void main(String[] args) {
        Config cfg = new Config("app.properties");

    }
}