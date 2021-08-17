package ru.job4j.block2.io.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Student {
    boolean isday;
    int age;
    String name;
    Praktika praktika;
    String[] language;

    public Student(boolean isday, int age, String name, Praktika praktika, String... language) {
        this.isday = isday;
        this.age = age;
        this.name = name;
        this.praktika = praktika;
        this.language = language;
    }


    @Override
    public String toString() {
        return "Student{"
                +  "isday=" + isday
                +                ", age=" + age
                +                ", name='" + name + '\''
                +                ", praktika=" + praktika
                +                ", language=" + Arrays.toString(language)
                +                '}';
    }

    public static void main(String[] args) {

        Student st = new Student(true, 22, "Sasha", new Praktika("kmz", 2001), "java", "python", "c++");
        final Gson gson = new GsonBuilder().create();

        final String studentJson =
                "{"
                        + "\"isday\":true,"
                        + "\"age\":22,"
                        + "\"name\":\"Sasha\","
                        + "\"praktika\":"
                        + "{"
                        + "\"factory\":\"kmz\","
                        + "\"age\":2001"
                        + "},"

                        + "\"language\":"
                        + " [\"java\",\"python\",\"c++\"]"
                        + " }";
        final Student studentMod = gson.fromJson(studentJson, Student.class);
        System.out.println(studentMod);
    }
}
