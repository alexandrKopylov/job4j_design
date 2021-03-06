package ru.job4j.map;


import java.util.*;

public class MyHashMap<K, V> implements Iterable {
    private Entry[] table;
    private int size;
    private int capacity = 8;
    private int modCount;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                sb.append(i + " = " + table[i] + "\n");
            }
        }
        return sb.toString();
    }

    public MyHashMap() {
        table = new Entry[capacity];
    }

    public boolean insert(K key, V value) {
        if (size == capacity) {
            resize();
        }
        int baket = hash(key) % capacity;
        baket = baket < 0 ? baket * (-1) : baket;
        if (table[baket] == null) {
            table[baket] = new Entry(key, value);
            size++;
            modCount++;
            return true;
        } else {
            return false;
        }
    }


    public void resize() {
        capacity *= 2;
        Entry[] newConteiner = new Entry[capacity];
        for (int i = 0; i < size; i++) {
            int baket = table[i].hash % capacity;
            baket = baket < 0 ? baket * (-1) : baket;
            newConteiner[baket] = table[i];
        }
        table = newConteiner;
    }


    public V get(K key) {
        int baket = hash(key) % capacity;
        baket = baket < 0 ? baket * (-1) : baket;

        Entry entry = table[baket];
        return entry == null ? null : (V) entry.value;
    }


    public boolean delete(K key) {
        int baket = hash(key) % capacity;
        baket = baket < 0 ? baket * (-1) : baket;
        if (table[baket] != null) {
            table[baket] = null;
            size--;
            modCount++;
            return true;
        } else {
            return false;
        }
    }


    static class Entry<K, V> {
        K key;
        V value;
        int hash;

        @Override
        public String toString() {
            return "[" + key + " = " + value + "]";
        }


        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = hash(key);
        }
    }

    @Override
    public Iterator<Entry> iterator() {
        return new Iterator<>() {
            int expectedModCount = modCount;
            private int indexIterator = 0;

            @Override
            public boolean hasNext() {
                return indexIterator < capacity;
            }

            @Override
            public Entry next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("collection modified (fail-fast)");
                }
                return (Entry) table[indexIterator++];
            }
        };
    }


    private static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
