package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    Node<T> first;
    Node<T> last;
    int size = 0;
    int modCount = 0;


    public boolean checkElement(int index) {
        return index >= 0 && index < size;
    }

    public T get(int index) {
        if (!checkElement(index)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T t = null;
        int currentIndex = 0;
        Node<T> temp = first;

        while (temp != null) {
            if (currentIndex == (size - 1)) {
                t =  temp.item;
                break;
            } else {
                temp = temp.next;
                currentIndex++;
            }
        }
        return t;
    }

    public void add(T value) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int expectedModCount = modCount;
            private int indexIterator = 0;
            private Node<T> nextNode = first;

            @Override
            public boolean hasNext() {
                return indexIterator < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("collection modified (fail-fast behavior)");
                }
                T t = nextNode.item;
                nextNode = nextNode.next;
                indexIterator++;
                return t;
            }
        };
    }


   public static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
