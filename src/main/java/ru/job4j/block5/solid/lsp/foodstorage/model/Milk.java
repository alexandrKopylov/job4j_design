package ru.job4j.block5.solid.lsp.foodstorage.model;

import java.util.Calendar;

public class Milk extends Food {
    public Milk(String name, Calendar expiryDate, Calendar createDate, Double price, Double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
