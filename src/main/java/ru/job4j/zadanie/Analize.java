package ru.job4j.zadanie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        if (previous.size() > current.size()) {
            info.deleted = previous.size() - current.size();
        }
        if (previous.size() < current.size()) {
            info.added = current.size() - previous.size();
        }

        if (previous.size() == current.size()) {
            for (int i = 0; i < current.size(); i++) {
                if (!current.get(i).name.equals(previous.get(i).name)) {
                    info.changed++;
                }
            }
        }
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }

}