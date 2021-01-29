package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleStack<T> extends MyLinkedList<T> {

    public T pop() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        T t = last.item;
        last = last.prev;
        if (last == null) {
            first = null;
        }
        size--;
        modCount++;
        return t;
    }

    public void push(T value) {
        add(value);
    }

    public boolean isEmpty() {
        return last == null && first == null;
    }
}