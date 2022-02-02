package ru.job4j.block5.solid.lsp.foodstorage;

import ru.job4j.block5.solid.lsp.foodstorage.model.Bread;
import ru.job4j.block5.solid.lsp.foodstorage.model.Food;
import ru.job4j.block5.solid.lsp.foodstorage.model.Milk;
import ru.job4j.block5.solid.lsp.foodstorage.store.Shop;
import ru.job4j.block5.solid.lsp.foodstorage.store.Store;
import ru.job4j.block5.solid.lsp.foodstorage.store.Trash;
import ru.job4j.block5.solid.lsp.foodstorage.store.Warehouse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ControllQuality {

    private List<Store> storeList;

    public ControllQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    public void sortFood(List<Food> foodList) {
        for (Food food : foodList) {
            for (Store store : storeList) {
                if (store.add(food)) {
                    break;
                }
            }
        }
    }
}
