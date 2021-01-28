package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleStack<T> extends MyLinkedList<T> {
    public T pop() {
        T t = null;
        if (last != null) {
            t = last.item;
            last = last.prev;
        } else {
            throw new NoSuchElementException();
        }
        return t;


    }

    public void push(T value) {
        add(value);
    }
}