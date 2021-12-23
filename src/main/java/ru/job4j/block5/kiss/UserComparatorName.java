package ru.job4j.block5.kiss;

import java.util.Comparator;

public class UserComparatorName  implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.name.compareTo(o2.name);
    }
}
