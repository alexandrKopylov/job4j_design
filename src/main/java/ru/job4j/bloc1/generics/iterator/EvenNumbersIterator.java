package ru.job4j.bloc1.generics.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (point < data.length) {
            if (data[point] % 2 == 0) {
                break;
            }
            point++;
        }
        return point < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }

    public static void main(String[] args) {
        int[] data = {1, 1, 3, 5, 6};
        EvenNumbersIterator ff = new EvenNumbersIterator(data);
        while (ff.hasNext()) {
            System.out.println(ff.next());
        }
    }
}
