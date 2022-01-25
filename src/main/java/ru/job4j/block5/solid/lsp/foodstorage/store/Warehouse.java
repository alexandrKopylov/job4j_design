package ru.job4j.block5.solid.lsp.foodstorage.store;

import ru.job4j.block5.solid.lsp.foodstorage.model.Food;

import java.util.List;
import java.util.function.Predicate;

public class Warehouse implements Store {
    @Override
    public List<? extends Food> findBy(Predicate<? extends Food> filter) {
        return null;
    }
}
