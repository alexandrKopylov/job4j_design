package ru.job4j.block2.io.serialization.json;

public class Praktika {
    String factory ;
    int age ;

    public Praktika(String factory, int age) {
        this.factory = factory;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Praktika{" +
                "factory='" + factory + '\'' +
                ", age=" + age +
                '}';
    }
}
