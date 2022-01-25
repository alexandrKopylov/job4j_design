package ru.job4j.block5.solid.lsp.foodstorage;

import ru.job4j.block5.solid.lsp.foodstorage.model.Bread;
import ru.job4j.block5.solid.lsp.foodstorage.model.Food;
import ru.job4j.block5.solid.lsp.foodstorage.model.Milk;
import ru.job4j.block5.solid.lsp.foodstorage.store.Store;

import java.time.ZoneOffset;
import java.util.*;

public class ControllQuality {
    private Store store;

    public static void main(String[] args) {
        List<Food> foodList = new ArrayList<>();

        Calendar createDate = new GregorianCalendar(2022, Calendar.JANUARY, 17);
        //  createDate.setTimeZone(TimeZone.getTimeZone(ZoneOffset.of("+1")));
        Calendar expiryDate = new GregorianCalendar(2022, Calendar.JANUARY, 22);


        Milk milk = new Milk("milk", createDate, expiryDate, 55.0, 0.1);

        Bread bread = new Bread("bread", createDate, expiryDate, 20.0, 0.2);

        foodList.add(milk);
        foodList.add(bread);


    }
}
