package ru.job4j.block5.solid.lsp.foodstorage.store;

import ru.job4j.block5.solid.lsp.foodstorage.model.Food;
import ru.job4j.block5.solid.reports.Employee;

import java.util.List;
import java.util.function.Predicate;

public interface Store {

    List<Food> findBy(Predicate<Food> filter);


}