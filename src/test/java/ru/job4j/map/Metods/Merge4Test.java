package ru.job4j.map.Metods;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Merge4Test {
    @Test
    public void whenListUsersAndMergeDublicateEmail() {

        Merge4 merge4 = new Merge4();

        Set<String> set1 = new HashSet<>();
        set1.add("xxx@ya.ru");
        set1.add("foo@gmail.com");
        set1.add("lol@mail.ru");

        Set<String> set2 = new HashSet<>();
        set2.add("foo@gmail.com");
        set2.add("ups@pisem.net");

        Set<String> set3 = new HashSet<>();
        set3.add("xyz@pisem.net");
        set3.add("vasya@pupkin.com");

        Set<String> set4 = new HashSet<>();
        set4.add("ups@pisem.net");
        set4.add("aaa@bbb.ru");

        Set<String> set5 = new HashSet<>();
        set5.add("xyz@pisem.net");

        Map<String, Set<String>> map = new HashMap<>();
        map.put("user1", set1);
        map.put("user2", set2);
        map.put("user3", set3);
        map.put("user4", set4);
        map.put("user5", set5);

        Map<String, Set<String>> result = merge4.merge(map);
        int expected = result.size();
        Assert.assertEquals(expected, 2);
    }
}