package ru.job4j.BLOCK2.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileBuffer {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            in.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}