package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleStack<T> extends MyLinkedList<T> {

    public T pop() {
        T t = null;
        if (last != null) {
            t = last.item;
            last = last.prev;
            if (last == null) {
                first = null;
            }

        } else {
            throw new NoSuchElementException();
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