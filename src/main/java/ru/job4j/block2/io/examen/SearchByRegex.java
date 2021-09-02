package ru.job4j.block2.io.examen;

import java.util.regex.Pattern;

public class SearchByRegex implements Search {
    String name;

    public SearchByRegex(String name) {
        this.name = name;
    }

    @Override
    public Pattern getSearchPattern() {
        return Pattern.compile(name);
    }
}
