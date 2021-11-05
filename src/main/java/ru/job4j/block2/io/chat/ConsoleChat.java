package ru.job4j.block2.io.chat;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "OUT";    
    private static final String STOP = "STOP";  
    private static final String CONTINUE = "CONT";   


    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> botAnswersLines = new ArrayList<>();
        StringBuilder builder;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            while ((line = br.readLine()) != null) {
                botAnswersLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        builder = dialogue(botAnswersLines);
        dialogLog(builder);
    }

    private StringBuilder dialogue(List<String> botAnswers) {
        StringBuilder builder = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("Go dialogue, input your text : ");
        builder.append("Go dialogue, input your text : " + System.lineSeparator());

        String humanAnswer = sc.nextLine();
        builder.append(humanAnswer + System.lineSeparator());

        while (!humanAnswer.trim().equalsIgnoreCase(OUT)) {
            String botAnswerText = "\t\t\t" + botAnswers.get(rnd.nextInt(botAnswers.size()));
            System.out.println(botAnswerText);
            builder.append(botAnswerText + System.lineSeparator());

            humanAnswer = sc.nextLine();
            builder.append(humanAnswer + System.lineSeparator());

            if (humanAnswer.trim().equalsIgnoreCase(STOP)) {
                while (!humanAnswer.trim().equalsIgnoreCase(CONTINUE)) {
                    humanAnswer = sc.nextLine();
                    builder.append(humanAnswer + System.lineSeparator());
                }
            }
        }

        System.out.println("Close dialogue. ");
        builder.append("Close dialogue. ");
        return builder;
    }

    public void dialogLog(StringBuilder builder) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("UTF-8"), false))) {
            pw.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("logChat.txt", "bot.txt");
        cc.run();

    }
}