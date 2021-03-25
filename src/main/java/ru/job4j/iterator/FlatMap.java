package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor;

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
        cursor = data.next();
    }

    private void check() {
        if (!cursor.hasNext() && data.hasNext()) {
            cursor = data.next();
        }
    }

    @Override
    public boolean hasNext() {
        check();
        boolean rsl = false;
        if (cursor == null) {
            rsl = false;
        }

        if (cursor.hasNext()) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public T next() {
        check();
        if (cursor == null) {
            throw new NoSuchElementException();
        }
        return cursor.next();
    }
}