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
        int baket = baketFromKey(key);
        if (table[baket] == null) {
            table[baket] = new Entry(key, value);
            size++;
            modCount++;
            return true;
        } else {
            return false;
        }
    }

    private int baketFromKey(K key) {
        int temp = hash(key) % capacity;
        temp = temp < 0 ? temp * (-1) : temp;
        return temp;
    }


    public void resize() {
        int oldCapacity = capacity;
        capacity *= 2;
        Entry[] newConteiner = new Entry[capacity];
        for (int i = 0; i < oldCapacity; i++) {
            newConteiner[baketFromKey((K) table[i].key)] = table[i];
        }
        table = newConteiner;
    }


    public V get(K key) {
        V result = null;
        int baket = baketFromKey(key);
        Entry entry = table[baketFromKey(key)];

        if (table[baket] != null &&
                hash(key) == entry.hash &&
                (key != null && key.equals(entry.key))) {
            result = (V) entry.value;
        }
        return result;
    }


    public boolean delete(K key) {
        boolean result = false;
        int baket = baketFromKey(key);
        Entry entry = table[baket];
        if (entry != null &&
                hash(key) == entry.hash &&
                (key != null && key.equals(entry.key))) {
            table[baket] = null;
            size--;
            modCount++;
            result = true;
        }
        return result;
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
                return table[indexIterator++];
            }
        };
    }


    private static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
