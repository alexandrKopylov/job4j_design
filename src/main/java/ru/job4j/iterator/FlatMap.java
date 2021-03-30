package ru.job4j.iterator;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor = Collections.emptyIterator();

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    private void check() {
        while (!cursor.hasNext() && data.hasNext()) {
            cursor = data.next();
        }
    }

    @Override
    public boolean hasNext() {
        check();
        boolean rsl = false;

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