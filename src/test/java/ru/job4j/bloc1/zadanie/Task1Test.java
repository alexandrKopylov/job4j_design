package ru.job4j.bloc1.zadanie;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1Test {
    @Test
    public void whenListUsersAndMergeDublicateEmail() {

        List<String> user1 = new ArrayList<>();
        user1.add("xxx@ya.ru");
        user1.add("foo@gmail.com");
        user1.add("lol@mail.ru");

        List<String> user2 = new ArrayList<>();
        user2.add("foo@gmail.com");
        user2.add("ups@pisem.net");

        List<String> user3 = new ArrayList<>();
        user3.add("xyz@pisem.net");
        user3.add("vasya@pupkin.com");

        List<String> user4 = new ArrayList<>();
        user4.add("ups@pisem.net");
        user4.add("aaa@bbb.ru");

        List<String> user5 = new ArrayList<>();
        user5.add("xyz@pisem.net");

        List<List<String>> lst = new ArrayList<>();
        lst.add(user1);
        lst.add(user2);
        lst.add(user3);
        lst.add(user4);
        lst.add(user5);

        List<Set<String>> rsl = Task1.mergeUsers(lst);


        assertThat(rsl.get(0).toString(), is("[aaa@bbb.ru, ups@pisem.net, lol@mail.ru, xxx@ya.ru, foo@gmail.com]"));
        assertThat(rsl.get(1).toString(), is("[vasya@pupkin.com, xyz@pisem.net]"));

    }
}