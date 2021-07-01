package ru.job4j.block2.io.duplicates;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            throw new IllegalArgumentException();
        }
        Files.walkFileTree(Path.of(args[0]), new DuplicatesVisitor());
    }
}