package ru.job4j.block2.io.examen;

import java.util.regex.Pattern;

public class SearchFullName implements Search {
    String str;

    public SearchFullName(String str) {
        this.str = str;
    }

    @Override
    public Pattern getSearchPattern() {
        StringBuilder sb = new StringBuilder();
        sb.append("^").append(str).append("$");
        return Pattern.compile(sb.toString());
    }
}
