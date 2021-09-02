package ru.job4j.block2.io.examen;

import java.util.regex.Pattern;

public class SearchByMask implements Search {
    String str;

    public SearchByMask(String str) {
        this.str = str;
    }

    @Override
    public Pattern getSearchPattern() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '*') {
                sb.append(".*");
            } else if (c == '.') {
                sb.append("\\.");
            } else {
                sb.append(c);
            }
        }
        return Pattern.compile(sb.toString());
    }
}