package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleStack<T>  {
    MyLinkedList<T> myLinkedList = new MyLinkedList<>();
    public T pop() {
        if (myLinkedList.last == null) {
            throw new NoSuchElementException();
        }
        T t = myLinkedList.last.item;
        myLinkedList.last = myLinkedList.last.prev;
        if (myLinkedList.last == null) {
            myLinkedList.first = null;
        }
        myLinkedList.size--;
        myLinkedList.modCount++;
        return t;
    }

    public void push(T value) {
        myLinkedList.add(value);
    }

    public boolean isEmpty() {
        return myLinkedList.last == null && myLinkedList.first == null;
    }
}