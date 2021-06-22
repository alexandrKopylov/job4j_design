package ru.job4j.block2.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (FileInputStream in = new FileInputStream("even.txt")) {
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] lines = text.toString().trim().split(" ");
        for (String line : lines) {
            int digit = Integer.parseInt(line);
            if (digit != 1  &&   digit / 2 == 0) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }

    }
}
