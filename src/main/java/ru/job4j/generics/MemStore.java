package ru.job4j.generics;

import java.util.*;

public final class MemStore<T extends Base>   implements Store<T>, Iterable<T> {

    private final List<T> mem = new ArrayList<>();

    private int indexOf(String id)  throws NoSuchElementException {
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
           throw new NoSuchElementException("no id");
        }
        return index;
    }

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = indexOf(id);
        mem.set(index, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int index = indexOf(id);
        mem.remove(index);
        return true;
    }

    @Override
    public T findById(String id) {
        int index = indexOf(id);
        return (T) mem.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return mem.iterator();
    }
}