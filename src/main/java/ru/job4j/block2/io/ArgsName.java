package ru.job4j.block2.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        String string = values.get(key);
        if (string == null) {
            throw new IllegalArgumentException("not this argument");
        }
        return string;
    }

    private void parse(String[] args) {
        for (String str : args) {
            str = str.replace("-", "");
            String[] mas = str.split("=");

            if (mas.length != 2) {
                throw new IllegalArgumentException("key or value equals null");
            }
            values.put(mas[0], mas[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }


    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}