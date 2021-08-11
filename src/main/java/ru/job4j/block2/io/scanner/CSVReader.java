package ru.job4j.block2.io.scanner;

import ru.job4j.block2.io.ArgsName;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class CSVReader {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 4) {
            throw new IllegalArgumentException("wrong count arguments");
        }
        CSVReader csvr = new CSVReader();
        ArgsName csvArgs = ArgsName.of(args);
        String path = csvArgs.get("path");
        String out = csvArgs.get("out");
        String delimiter = csvArgs.get("delimiter");
        String filter = csvArgs.get("filter");

        csvr.validation(path, out, filter);
        List<Integer> listIndexsesFilter = csvr.getColumns(path, delimiter, filter);
        String strBild = csvr.reader(listIndexsesFilter, path, delimiter);
        output(out, strBild);
    }

    private List<Integer> getColumns(String path, String delimiter, String filter) throws FileNotFoundException {
        List<Integer> listIndexses = new ArrayList<>();
        Scanner sc = new Scanner(new File(path));
        if (sc.hasNextLine()) {
            String[] namesColumns = sc.nextLine().split(delimiter);
            for (int i = 0; i < namesColumns.length; i++) {
                if (filter.contains(namesColumns[i])) {
                    listIndexses.add(i);
                }
            }
        }
        return listIndexses;
    }

    private static void output(String out, String strBild) {
        if (out.equals("stdout")) {
            System.out.println(strBild);
        } else {
            try (PrintWriter pw = new PrintWriter(new FileWriter(out, StandardCharsets.UTF_8, true))) {
                pw.write(strBild);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void validation(String path, String out, String filter) {
        if (!new File(path).exists()) {
            throw new IllegalArgumentException("wrong file csv");
        }

        boolean outconsole = out.equals("stdout");
        if (!outconsole) {
            File fileOut = new File(out);


            if (!fileOut.exists()) {

                try {
                    fileOut.createNewFile();
                } catch (IOException e) {
                    System.out.println("problem with out file");
                    e.printStackTrace();
                }
            }
        }

        String[] stringFilter = filter.split(",");
        if (stringFilter.length > 5) {
            throw new IllegalArgumentException("wrong argument filter > 5");
        }
    }

    private String reader(List<Integer> listIndexses, String path, String delimiter) throws FileNotFoundException {
        Pattern ptn = Pattern.compile("\\n|" + delimiter);
        Scanner sc = new Scanner(new File(path)).useDelimiter(ptn);
        StringJoiner line = new StringJoiner(System.lineSeparator());
        while (sc.hasNextLine()) {
            StringJoiner joiner = new StringJoiner(delimiter);
            String[] namesColumns = sc.nextLine().split(delimiter);
            for (Integer indexFilter : listIndexses) {
                joiner.add(namesColumns[indexFilter]);
            }
            line.add(joiner.toString());
        }
        return line.toString();
    }

}
