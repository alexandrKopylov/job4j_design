package ru.job4j.BLOCK2.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class LogFilter {
    private static Pattern pattern = Pattern.compile(".*\\s404\\s.*");

    public static List<String> filter(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {

            for (String line = in.readLine(); line != null; line = in.readLine()) {
                if (  pattern.matcher(line).matches()) {
                    list.add(line);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}