package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T>  implements Iterable<T> {
    protected  Node<T> head;
    private  int size;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }

        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T t = head.value;
        head = head.next;
        size--;
        return t;
    }

    public T deleteLast() {
        if (size == 1) {
            T t = head.value;
            head = null;
            size--;
            return t;
        } else {
            Node<T> tail = head;
            int counter = 0;
            while (counter < size - 2) {
                tail = tail.next;
                counter++;
            }
            T t = tail.next.value;
            tail.next = null;
            size--;
            return t;
        }
    }


    public void revert() {
        Node<T> previous = null;
        Node<T> current = head;
        Node<T> forward;
        while (current != null) {
            forward = current.next;
            current.next = previous;
            previous = current;
            if (forward != null) {
                current = forward;
            } else {
                break;
            }
        }
        head = current;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public   void printing() {
        Node<T> tail = head;
        System.out.println(tail.value);
        while (tail.next != null) {
            tail = tail.next;
            System.out.println(tail.value);
        }
    }

    public static void main(String[] args) {
        ForwardLinked<Integer> ff  = new ForwardLinked<>();
        ff.add(1);
        ff.add(2);
        ff.add(3);
        ff.add(4);
        ff.add(5);
      //  System.out.println("------------------");
       // System.out.println("head = " + ff.head.value);
         ff.printing();
        System.out.println("------------------");
        System.out.println(ff.deleteLast());
        System.out.println(ff.deleteLast());
        System.out.println(ff.deleteLast());
        System.out.println(ff.deleteFirst());
        System.out.println(ff.deleteFirst());
        System.out.println("size=" + ff.size);
    }
}