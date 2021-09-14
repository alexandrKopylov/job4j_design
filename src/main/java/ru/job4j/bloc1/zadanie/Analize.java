package ru.job4j.bloc1.zadanie;

import java.util.*;

public class Analize {


    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();

        Map<Integer, String> previousMap = new HashMap();
        for (User user : previous) {
            previousMap.put(user.id, user.name);
        }
        Map<Integer, String> currentMap = new HashMap();
        for (User user : current) {
            currentMap.put(user.id, user.name);
        }

        for (int keyId : previousMap.keySet()) {
            // boolean bol1 = ;
            // boolean bol2 =);

            if (currentMap.containsKey(keyId) && !currentMap.get(keyId).contains(previousMap.get(keyId))) {
                info.changed++;
            } else if (!currentMap.containsKey(keyId)) {
                info.deleted++;
            }
        }
        info.added = currentMap.size() - (previousMap.size() - info.deleted);
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }

}