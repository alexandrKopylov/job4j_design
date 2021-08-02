package ru.job4j.block2.io.scanner;

import ru.job4j.block2.io.ArgsName;

import java.io.*;
import java.nio.charset.Charset;
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
        String strBild = csvr.reader( arg1, arg3, arg4);
        out(arg2, strBild);

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

    private String reader( String path, String delimiter, String filter) throws FileNotFoundException {

       // StringBuilder strBild = new StringBuilder();
        //strBild.append(System.lineSeparator());
        Pattern ptn = Pattern.compile("\\n|" + delimiter);
        Scanner sc = new Scanner(new File(path)).useDelimiter(ptn);
        StringJoiner line = new StringJoiner(System.lineSeparator());

        int n = 0;
        String token;

        while (sc.hasNext()) {
            StringJoiner joiner = new StringJoiner(delimiter);
            token = sc.next().trim();
            if (filter.contains(StructuraCSV.name.toString())   && n == 0) {
                joiner.add(token);
            }
            n++;
            token = sc.next().trim();
            if (filter.contains(StructuraCSV.age.toString())   && n == 1) {
                joiner.add(token);
            }
            n++;
            token = sc.next().trim();
            if (filter.contains(StructuraCSV.birthDate.toString())   && n == 2) {
                joiner.add(token);
            }
            n++;
            token = sc.next().trim();
            if (filter.contains(StructuraCSV.education.toString())   && n == 3) {
                joiner.add(token);
            }
            n++;
            token = sc.next().trim();
            if (filter.contains(StructuraCSV.children.toString())   && n == 4) {
                joiner.add(token);
            }
            n++;
            if (n == 5) {
                line.add(joiner.toString());
                n = 0;
            }
        }

        return line.toString();
    }
}
