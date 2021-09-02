package ru.job4j.block2.io.examen;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchVisitor extends SimpleFileVisitor<Path> {
    Pattern ptn;
    private List<Path> resultList = new ArrayList<>();

    SearchVisitor(Pattern ptn) {
        this.ptn = ptn;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Matcher matcher = ptn.matcher(file.toFile().getName());
        if (matcher.find()) {
            resultList.add(file);
        }
        return super.visitFile(file, attrs);
    }

    public List<Path> getPaths() {
        return resultList;
    }
}
