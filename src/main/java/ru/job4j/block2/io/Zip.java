package ru.job4j.block2.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalArgumentException("wrong count arguments");
        }

        ArgsName zip = ArgsName.of(args);

        Path args1 = Paths.get(zip.get("d"));

        if (!args1.toFile().exists() && !args1.toFile().isDirectory()) {
            throw new IllegalArgumentException("wrong directory");
        }

        Path root = args1.getParent();
        Path args3 = Paths.get(zip.get("o"));
        args3 = root.resolve(args3);
        zipDir(args1, zip.get("e"), args3);
    }

    public static void zipDir(Path root, String str, Path pathOut) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(str));
        Files.walkFileTree(root, searcher);
        List<Path> list = searcher.getPaths();
        packFiles(list, pathOut);
    }

    public static void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toFile())))) {
            target = target.getParent();
            for (Path path : sources) {
                Path root = path.getRoot();
                Path result = target.relativize(path);

                zip.putNextEntry(new ZipEntry(result.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}