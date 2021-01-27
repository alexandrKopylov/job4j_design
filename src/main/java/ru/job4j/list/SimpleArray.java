package ru.job4j.list;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] container;
    private int modCount = 0;
    private int capacity;
    private int index = 0;

    public SimpleArray(int capacity) {
        container = new Object[capacity];
        this.capacity = capacity;
    }

    public SimpleArray() {
        container = new Object[10];
        this.capacity = 10;
    }

    public T get(int index) {
        if (!checkElement(index)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) container[index];
    }

    public boolean checkElement(int index) {
        return index >= 0 && index < this.index;
    }

    public void add(T model) {
        if (capacity == index) {
            int oldCapacity = capacity;
            capacity = (capacity * 3) / 2 + 1;
            Object[] newConteiner = Arrays.copyOf(container, capacity);
            container = newConteiner;
          }
        container[index] = model;
        index++;
        modCount++;
        }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int expectedModCount = modCount;
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
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("collection modified (fail-fast)");
                }
                return (T) container[indexIterator++];
            }
        };
    }
}
