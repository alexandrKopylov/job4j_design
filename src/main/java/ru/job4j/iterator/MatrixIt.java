package ru.job4j.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public  class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }


    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = row; i < data.length /*&& data[i].length == column*/; i++) {

//            if (data[i].length != 0) {
//                result = true;
//                break;
//            }

            row++;
            column = 0;
        }

        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
       return data[row][column++];
    }

    public static void main(String[] args) {
        int[][] ppp = {{555}, {777}};
        MatrixIt mi = new MatrixIt(ppp);
        int m = 0;
        while (m < 6) {
            int value = mi.next();
            m++;
        }

    }
}
