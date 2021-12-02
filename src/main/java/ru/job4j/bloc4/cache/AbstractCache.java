package ru.job4j.bloc4.cache;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key) {
        SoftReference<V> softValue = cache.get(key);
        if (softValue == null) {
            return null;
        }
        return softValue.get();
    }

    protected abstract V load(K key) throws IOException;
}

