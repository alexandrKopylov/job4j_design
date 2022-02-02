package ru.job4j.block5.solid.lsp.foodstorage;

import ru.job4j.block5.solid.lsp.foodstorage.model.Bread;
import ru.job4j.block5.solid.lsp.foodstorage.model.Food;
import ru.job4j.block5.solid.lsp.foodstorage.model.Milk;
import ru.job4j.block5.solid.lsp.foodstorage.store.Shop;
import ru.job4j.block5.solid.lsp.foodstorage.store.Store;
import ru.job4j.block5.solid.lsp.foodstorage.store.Warehouse;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ControllQuality {
    private Store store;



    /**
     * @param cd - createDate
     * @param ed - expiryDate
     *           ct - currentTime
     *           cded - разница между  createDate и expiryDate
     *           cted - разница между currentTime  и expiryDate
     * @return
     */
    private int expirationPercent(LocalDateTime cd, LocalDateTime ed) {
        LocalDateTime ct = LocalDateTime.now();

        double cded = (double) cd.until(ed, ChronoUnit.HOURS);
        double cted = (double) ct.until(ed, ChronoUnit.HOURS);

        System.out.println("currentTime = " + ct);
        System.out.println("createDate = " + cd);
        System.out.println("expiryDate = " + ed);
        System.out.println("diff= " + cded);
        System.out.println("diff= " + cted);

        return (int) (cted / cded * 100);
    }


    public void sortQuality(Food food) {
        int percent = expirationPercent(food.getCreateDate(), food.getExpiryDate());
        System.out.println(percent);

        if (percent >= 0 && percent < 25) {
            store = new Warehouse();
        } else if (percent >= 25 && percent < 75) {
            store = new Shop();
        }

    }

    public static void main(String[] args) {
        List<Food> foodList = new ArrayList<>();

        ControllQuality cq = new ControllQuality();

        LocalDateTime createDate = LocalDateTime.now();
        createDate = createDate.minusDays(5);
        LocalDateTime expiryDate = createDate.plusDays(10);


        Milk milk = new Milk("milk", createDate, expiryDate, 55.0, 0.1);
        // Bread bread = new Bread("bread", createDate, expiryDate, 20.0, 0.2);

        foodList.add(milk);
        //foodList.add(bread);

        for (Food food : foodList) {
            cq.sortQuality(food);
        }


    }
}
