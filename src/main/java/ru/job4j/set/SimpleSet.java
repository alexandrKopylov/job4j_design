package ru.job4j.set;

import ru.job4j.list.SimpleArray;

import java.util.*;

public class SimpleSet<T> implements Iterable<T> {

    SimpleArray<T>  simpleArray = new SimpleArray<>();

    public boolean add(T t) {
        boolean bool = true;
        for (T t1 : simpleArray) {
            if (t1.equals(t)) {
                bool = false;
                break;
            }
        }
        if (bool) {
            simpleArray.add(t);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }

    public static void main(String[] args) {

//
//        List<String> expected = List.of("ss", "dd", "bb");
//        SimpleSet<String> set = new SimpleSet<>();
//        expected.forEach(set::add);
//
//        List<String> actual = new ArrayList<>();
//
//        for (String str : set) {
//            actual.add(str);

        SimpleSet<String> ss = new SimpleSet<>();
     //   List<String> str = List.of("aaa", "bbb", "ccc", "aaa", null, null);
     //   ss.addAll(str);
        ss.add(null);
      //  ss.add(null);
        System.out.println(ss);



        }
    }


