package ru.job4j.block5.template;

import java.util.Map;

public interface Generator {
    String produce(String template, Map<String, String> args);
}