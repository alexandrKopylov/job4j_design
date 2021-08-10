package ru.job4j.block2.io.serialization.jsonToPojo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public boolean isIsday() {
        return isday;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Praktika getPraktika() {
        return praktika;
    }

    public String[] getLanguage() {
        return language;
    }


    @Override
    public String toString() {
        return "Student{" +
                "isday=" + isday +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", praktika=" + praktika +
                ", language=" + Arrays.toString(language) +
                '}';
    }

    public static void main(String[] args) {
        JSONObject jsonPraktika = new JSONObject(
                        "{"
                        + "\"factory\":\"kmz\","
                        + "\"anne\":2001"
                        + "}");

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        JSONArray jsonLanguages = new JSONArray(list);

        final Student stud = new Student(true, 22, "Sasha", new Praktika("kmz", 2001), "java", "python", "c++");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isDay", stud.isIsday());
        jsonObject.put("age", stud.getAge());
        jsonObject.put("name", stud.getName());
        jsonObject.put("praktika", jsonPraktika);
        jsonObject.put("languages", jsonLanguages);

        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(stud).toString());
    }
}
