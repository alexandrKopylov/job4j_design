package ru.job4j.block5.kiss;


import java.util.*;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return condition(value, comparator, p -> p > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return condition(value, comparator, p -> p < 0);
    }

    public <T> T condition(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        Iterator<T> i = value.iterator();
        T candidate = i.next();
        while (i.hasNext()) {
            T next = i.next();
            if (predicate.test(comparator.compare(next, candidate))) {
                candidate = next;
            }
        }
        return candidate;
    }
}

