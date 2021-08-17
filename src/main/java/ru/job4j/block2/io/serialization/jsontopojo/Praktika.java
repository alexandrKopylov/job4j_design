package ru.job4j.block2.io.serialization.jsontopojo;

public class Praktika {
    String factory;
    int anne;


    public Praktika(String factory, int anne) {
        this.factory = factory;
        this.anne = anne;
    }

    public String getFactory() {
        return factory;
    }

    public int getAnne() {
        return anne;
    }

    @Override
    public String toString() {
        return "Praktika{"
                +                "factory='" + factory + '\''
                +                ", anne=" + anne
                +                '}';
    }
}
