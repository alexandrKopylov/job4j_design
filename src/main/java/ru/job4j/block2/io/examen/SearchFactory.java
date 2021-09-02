package ru.job4j.block2.io.examen;

public class SearchFactory {
    public static Search createSearch(String str, String name) {
        switch (str) {
            case "mask":
                return new SearchByMask(name);
            case "name":
                return new SearchFullName(name);
            case "regex":
                return new SearchByRegex(name);
            default:
                return null;
        }

    }
}


