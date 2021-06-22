package ru.job4j.block2.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {

            try (BufferedWriter writter = new BufferedWriter(new FileWriter(target))) {
                String line;
                boolean startDiapazon = false;

                while ((line = reader.readLine()) != null) {
                    String[] mas = line.split(" ");
                    if ((mas[0].equals("400") || mas[0].equals("500")) && !startDiapazon) {
                                 writter.write(mas[1] + ";");
                        startDiapazon = true;
                    }
                    if ((mas[0].equals("200") || mas[0].equals("300")) && startDiapazon) {
                              writter.write(mas[1] + System.lineSeparator());
                        startDiapazon = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", "unavailable.csv");
    }
}