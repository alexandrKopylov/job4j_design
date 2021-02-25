package ru.job4j.set;

import ru.job4j.list.SimpleArray;

import java.util.*;
import java.util.jar.JarOutputStream;

public class SimpleSet<T> implements Iterable<T> {

    SimpleArray<T> simpleArray = new SimpleArray<>();

    public boolean contains(T value) {
        boolean isNewElement = true;
        for (T item : simpleArray) {
            if (Objects.equals(value, item)) {
                isNewElement = false;
                break;
            }
        }
        return isNewElement;
    }

    public void add(T t) {
        if (contains(t)) {
            simpleArray.add(t);
        }
    }


    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }
}



