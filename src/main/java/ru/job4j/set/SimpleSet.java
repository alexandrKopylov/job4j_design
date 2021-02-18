package ru.job4j.set;

import ru.job4j.list.SimpleArray;

import java.util.*;

public class SimpleSet<T> implements Iterable<T> {

    SimpleArray<T>  simpleArray = new SimpleArray<>();

    public void add(T t) {
        boolean isNewElement = true;

        for (T item : simpleArray) {
            if (item == null) {
                if (t == null) {
                    isNewElement = false;
                    break;
                }
            } else if (item.equals(t)) {
                isNewElement = false;
                break;
            }
        }

        if (isNewElement) {
            simpleArray.add(t);
        }
    }


    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }

    }


