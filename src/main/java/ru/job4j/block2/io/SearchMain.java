package ru.job4j.block2.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class SearchMain {
    public static void main(String[] args) throws IOException {
        String str = "c:\\Program Files\\AutoCAD 2010";
        Predicate<Path> predicate = p -> p.toFile().getName().endsWith("exe");
        Path root = Paths.get(str);
        search(root, predicate).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> predicate) throws IOException {
        PrintFiles searcher = new PrintFiles(predicate);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}