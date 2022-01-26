package ru.job4j.block5.solid.lsp.foodstorage.store;

import ru.job4j.block5.solid.lsp.foodstorage.model.Food;
import ru.job4j.block5.solid.reports.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Shop implements Store {

    private final List<Food> foods = new ArrayList<>();

    @Override
    public List<Food> findBy(Predicate<Food> filter) {
        return null;
    }

    @Override
    public void add(Food food) {
        foods.add(food);
    }

}
