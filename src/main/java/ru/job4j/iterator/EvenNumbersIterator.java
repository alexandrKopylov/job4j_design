package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int pointHasNext = 0;
    private int pointNext = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {

        boolean result = false;
        for (int i = pointHasNext; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                result = true;
                break;
            }
            pointHasNext++;
        }
        return pointHasNext < data.length && result;
    }

    @Override
    public Integer next() {
        for (int i = pointNext; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                break;
            }
            pointNext++;
        }

        if (pointNext == data.length) {
            throw new NoSuchElementException();
        }
        return data[pointNext++];
    }

    public static void main(String[] args) {
        Iterator<Integer> it = new EvenNumbersIterator(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
    }
}
