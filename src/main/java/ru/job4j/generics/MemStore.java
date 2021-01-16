package ru.job4j.generics;

import java.util.*;

public final class MemStore<T extends Base>   implements Store<T>, Iterable<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
            mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                mem.remove(i);
                mem.add(i, model);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                mem.remove(i);
                return true;
            }
        }
        return false;
    }



    @Override
    public T findById(String id) {
        if (!checkId(id)) {
            throw new NoSuchElementException("no id");
        }
        T t = null;
        for (T value : mem) {
            if (value.getId().equals(id)) {
                t =  value;
            }
        }
        return t;
    }

    public boolean checkId(String id) {

        for (T t : mem) {
            if (t.getId().equals(id)) {
                return true;
            }
        }
        return  false;
    }


    @Override
    public Iterator<T> iterator() {
        return mem.iterator();
    }
}