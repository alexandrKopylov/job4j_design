package ru.job4j.bloc4;

public class User {
    int id;
    int age;
    String firstName;
    String lastName;


    public User(int id, int age, String firstName, String lastName) {
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    @Override
    protected void finalize() {
        System.out.printf("Removed: %d %s %s%n", id, firstName, lastName);
    }
}