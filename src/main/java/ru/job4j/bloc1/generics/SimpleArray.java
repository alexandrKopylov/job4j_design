package ru.job4j.bloc1.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private final Object[] data;
    private int index = 0;

    public SimpleArray(int size) {
        data = new Object[size];
    }


    public void add(T model) throws ArrayIndexOutOfBoundsException {
        data[index++] = model;
    }

    public void set(int element, T model) {
        if (!checkElement(element)) {
            throw new NoSuchElementException();
        }
        data[element] = model;
    }

    public void remove(int element) {
        if (!checkElement(element)) {
            throw new NoSuchElementException();
        }
        System.arraycopy(data, element + 1, data, element, index - element);
        data[index--] = null;
    }

    public T get(int element) {
        if (!checkElement(element)) {
            throw new NoSuchElementException();
        }
        return (T) data[element];
    }

    public boolean checkElement(int element) {
        return element >= 0 && element < index;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int indexIterator = 0;

            @Override
            public boolean hasNext() {
                return indexIterator < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) data[indexIterator++];
            }
        };
    }
}
