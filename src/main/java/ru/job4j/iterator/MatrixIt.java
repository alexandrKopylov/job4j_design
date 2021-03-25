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
        while (row < data.length && data[row].length == column) {
            row++;
            column = 0;
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
       return data[row][column++];
    }

    public static void main(String[] args) {
        int[][] ppp = {{1,2}, {8,9} , {11,12,13}};    MatrixIt mi = new MatrixIt(ppp);
        while(mi.hasNext()){
          int ttt =  mi.next();
        }


    }
}
