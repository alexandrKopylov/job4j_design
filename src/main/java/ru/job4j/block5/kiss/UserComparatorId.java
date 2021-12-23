package ru.job4j.block5.kiss;

import java.util.Comparator;

public class UserComparatorId implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.id - o2.id;
    }
}
