package ru.job4j.bloc1.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        User user1 = new User("Sasha", 2, new GregorianCalendar(2017, Calendar.JANUARY, 1));
        User user2 = new User("Sasha1", 1, new GregorianCalendar(2018, Calendar.JANUARY, 2));
        User user3 = new User("Sasha", 3, new GregorianCalendar(2019, Calendar.JANUARY, 23));
        User user4 = new User("Sa2sha", 4, new GregorianCalendar(2007, Calendar.JANUARY, 4));
        User user5 = new User("Sas4ha", 5, new GregorianCalendar(2016, Calendar.JANUARY, 5));
        User user6 = new User("S6asha", 6, new GregorianCalendar(2015, Calendar.JANUARY, 6));
        User user7 = new User("Sas7ha", 7, new GregorianCalendar(2013, Calendar.JANUARY, 7));


        System.out.println(1 & 15);
        System.out.println(17 & 15);

    }
}