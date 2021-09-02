package ru.job4j.block2.io.examen;


import ru.job4j.block2.io.ArgsName;
import ru.job4j.block2.io.SearchFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.util.regex.Pattern;

public class SearchFilesByCriterion {
    List<Path> list;

    public SearchFilesByCriterion() {
        this.list = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("wrong count arguments (there should be 4 arguments)");
        }
        SearchFilesByCriterion sfc = new SearchFilesByCriterion();
        ArgsName csvArgs = ArgsName.of(args);
        String startSearch = csvArgs.get("d");
        String name = csvArgs.get("n");
        String typeSearch = csvArgs.get("t");
        String fileLog = csvArgs.get("o");
        sfc.validation(startSearch, typeSearch, fileLog);
        Search sch = SearchFactory.createSearch(typeSearch, name);
        assert sch != null;
        sfc.list = sfc.search(Paths.get(startSearch), sch.getSearchPattern());
        sfc.writeLog(fileLog);
    }

    private void writeLog(String out) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(out, StandardCharsets.UTF_8, false))) {
            for (Path s : list) {
                pw.println(s.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Path> search(Path root, Pattern ptn) throws IOException {
        SearchVisitor searcher = new SearchVisitor(ptn);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private void validation(String path, String typeSearch, String fileLog) {
        if (!new File(path).isDirectory()) {
            throw new IllegalArgumentException("wrong directory ( Specify the correct directory )");
        }

        File fileOut = new File(fileLog);
        if (!fileOut.exists()) {
            try {
                fileOut.createNewFile();
            } catch (IOException e) {
                System.out.println("problem with log file ( Specify the correct file )");
                e.printStackTrace();
            }
        }

        if (!"mask name regex".contains(typeSearch)) {
            throw new IllegalArgumentException("wrong parametr -n (only  'mask' or  'name' or 'regex') ");
        }
    }
}

