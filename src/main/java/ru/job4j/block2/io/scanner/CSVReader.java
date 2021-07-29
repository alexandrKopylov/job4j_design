package ru.job4j.block2.io.scanner;

import ru.job4j.block2.io.ArgsName;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
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

        Selector selector = csvr.validation(arg1, arg2, arg4);
        StringBuilder strBild = csvr.reader(selector, arg1, arg3);
        out(arg2, strBild);

    }

    private static void out(String arg2, StringBuilder strBild) {
        if (arg2.equals("stdout")) {
            System.out.println(strBild.toString());
        } else {
            try (PrintWriter pw = new PrintWriter(new FileWriter(arg2, StandardCharsets.UTF_8, true))) {
                pw.write(strBild.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Selector validation(String path, String out, String filter) {
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
        Selector sel = new Selector();
        if (filter.contains("name")) {
            sel.setName(true);
        }
        if (filter.contains("age")) {
            sel.setAge(true);
        }
        if (filter.contains("birthDate")) {
            sel.setBirthDate(true);
        }
        if (filter.contains("education")) {
            sel.setEducation(true);
        }
        if (filter.contains("children")) {
            sel.setChildren(true);
        }
        return sel;
    }

    private StringBuilder reader(Selector selector, String path, String delimiter) throws FileNotFoundException {

        StringBuilder strBild = new StringBuilder();
        strBild.append(System.lineSeparator());
        Pattern ptn = Pattern.compile("\\n|" + delimiter);
        Scanner sc = new Scanner(new File(path)).useDelimiter(ptn);

        int n = 0;
        String token;

        while (sc.hasNext()) {

            token = sc.next().trim();
            if (selector.isName() && n == 0) {
                strBild.append(token + "\t\t");
            }
            n++;
            token = sc.next().trim();
            if (selector.isAge() && n == 1) {
                strBild.append(token + "\t\t");
            }
            n++;
            token = sc.next().trim();
            if (selector.isBirthDate() && n == 2) {
                strBild.append(token + "\t\t");
            }
            n++;
            token = sc.next().trim();
            if (selector.isEducation() && n == 3) {
                strBild.append(token + "\t\t");
            }
            n++;
            token = sc.next().trim();
            if (selector.isChildren() && n == 4) {
                strBild.append(token + "\t\t");
            }
            n++;
            if (n == 5) {
                strBild.append(System.lineSeparator());
                n = 0;
            }
        }
        strBild.append("--------------------------------------------------------------------------");
        return strBild;
    }
}
