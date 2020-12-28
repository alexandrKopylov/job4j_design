package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T>, Iterator<T> {
    private final Object[] data;
    private int index = 0;

    public SimpleArray(int size) {
        data = new Object[size];
    }


    public void add(T model) throws ArrayIndexOutOfBoundsException  {
        data[index++] = model;
    }

    public void set(int element, T model)  {
        if (checkElement(element)) {
            data[element] = model;
        } else {
            System.out.println("invalid element ");
        }
    }

    public void remove(int element)   {
        if (checkElement(element)) {
            System.arraycopy(data, element + 1, data, element, index - element);
            data[index--] = null;
        } else {
            System.out.println("invalid element ");
        }
    }

    public T get(int element) {
        if (checkElement(element)) {
            return (T) data[element];
        } else {
            System.out.println("invalid element , return null");
            return null;
        }
    }

    public boolean checkElement(int element) {
        return element >= 0 && element <= index;
    }


    public Iterator<T> iterator() {
        index = 0;
        return this;
    }

    @Override
    public boolean hasNext() {
        return index < data.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (T) data[index++];
    }
}
