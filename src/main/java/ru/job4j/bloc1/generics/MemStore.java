package ru.job4j.bloc1.generics;

import java.util.*;

public final class MemStore<T extends Base>   implements Store<T>, Iterable<T> {

    private final List<T> mem = new ArrayList<>();

    private int indexOf(String id) {
        int index = 0;
        boolean exist = false;
        for (T model : mem) {
            if (model.getId().equals(id)) {
                exist = true;
                break;
            }
            index++;
        }
        if (!exist) {
          index = -1;
        }
        return index;
    }

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            mem.set(index, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            mem.remove(index);
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T t = null;
        int index = indexOf(id);
        if (index != -1) {
            t = (T) mem.get(index);
        }
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return mem.iterator();
    }
}