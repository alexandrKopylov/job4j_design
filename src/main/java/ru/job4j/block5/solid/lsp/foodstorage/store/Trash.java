package ru.job4j.block5.solid.lsp.foodstorage.store;

import ru.job4j.block5.solid.lsp.foodstorage.model.Food;

import java.util.List;
import java.util.function.Predicate;

public class Trash implements Store {
    @Override
    public List<Food> findBy(Predicate<Food> filter) {
        return null;
    }

    @Override
    public void add(Food food) {

    }
}
