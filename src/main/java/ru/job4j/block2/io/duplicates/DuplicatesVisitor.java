package ru.job4j.block2.io.duplicates;


import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {


    Set<FileProperty> filePropertySet = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        FileProperty fp = new FileProperty(file.toFile().length(), file.getFileName().toString());
        if (!filePropertySet.add(fp)) {
            System.out.println("dublicate : " + file.toAbsolutePath().toString());
        }
        return super.visitFile(file, attrs);
    }
}