package ru.job4j.block2.io.examen;


import ru.job4j.block2.io.ArgsName;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFilesByCriterion {

    List<String> list;

    public SearchFilesByCriterion() {
        this.list = new ArrayList<>();
    }

    public static void main(String[] args) {
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
        Pattern pattern = sfc.getPattern(name, typeSearch);
        sfc.search(startSearch, pattern);
        sfc.writeLog(fileLog);

    }

    private void writeLog(String out) {
        StringJoiner lines = new StringJoiner(System.lineSeparator());
        for (String s : list) {
            lines.add(s);
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(out, StandardCharsets.UTF_8, false))) {
            pw.write(lines.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Pattern getPattern(String name, String typeSearch) {
        if (typeSearch.equals("mask")) {
            name = name.replace("*", "");
        }
        if (typeSearch.equals("name")) {
            name = "^" + name + "$";
        }
        Pattern ptn = Pattern.compile(name);
        return ptn;
    }

    private void search(String startSearch, Pattern ptn) {
        File folder = new File(startSearch);
        for (File subfile : folder.listFiles()) {
            if (subfile.isDirectory()) {
                search(startSearch + "\\" + subfile.getName(), ptn);
            } else {
                Matcher matcher = ptn.matcher(subfile.getName());
                if (matcher.find()) {
                    list.add(subfile.getAbsolutePath());
                }
            }

        }
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

