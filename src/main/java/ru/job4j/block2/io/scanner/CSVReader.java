package ru.job4j.block2.io.scanner;

import ru.job4j.block2.io.ArgsName;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
        String arg1 = csvArgs.get("path");
        String arg2 = csvArgs.get("out");
        String arg3 = csvArgs.get("delimiter");
        String arg4 = csvArgs.get("filter");

        csvr.validation(arg1, arg2, arg4);
        String[] columns = csvr.getColumns(arg1, arg3);
        String strBild = csvr.reader(columns, arg1, arg3, arg4);
        out(arg2, strBild);
    }

    private String[] getColumns(String arg1, String arg3) throws FileNotFoundException {
        String[] mas = null;
        Scanner sc = new Scanner(new File(arg1));
        if (sc.hasNextLine()) {
            mas = sc.nextLine().split(arg3);
        }
        return mas;
    }
    private static void out(String arg2, String strBild) {
        if (arg2.equals("stdout")) {
            System.out.println(strBild);
        } else {
            try (PrintWriter pw = new PrintWriter(new FileWriter(arg2, StandardCharsets.UTF_8, true))) {
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
    private String reader(String[] columns, String path, String delimiter, String filter) throws FileNotFoundException {
        Pattern ptn = Pattern.compile("\\n|" + delimiter);
        Scanner sc = new Scanner(new File(path)).useDelimiter(ptn);
        StringJoiner line = new StringJoiner(System.lineSeparator());
        String token;
        while (sc.hasNext()) {
            StringJoiner joiner = new StringJoiner(delimiter);
            for (int i = 0; i < columns.length; i++) {
                token = sc.next().trim();
                if (filter.contains(columns[i])) {
                    joiner.add(token);
                }
            }
            line.add(joiner.toString());
        }
        return line.toString();
    }

}
