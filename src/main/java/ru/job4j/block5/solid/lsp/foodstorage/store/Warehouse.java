package ru.job4j.block5.solid.lsp.foodstorage.store;

import ru.job4j.block5.solid.lsp.foodstorage.model.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Warehouse implements Store {
    List<Food> foods = new ArrayList<>();

    @Override
    public List<Food> findBy(Predicate<Food> filter) {
        return foods.stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public boolean add(Food food) {
        double percent = expirationPercent(food.getCreateDate(), food.getExpiryDate());
        if (percent < 25) {
            foods.add(food);
            return true;
        }
        return false;
    }
}
