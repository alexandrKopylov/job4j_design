package ru.job4j.block5.solid.lsp.foodstorage.model;

import java.time.LocalDate;

public class Bread extends Food {

    public Bread(String name, LocalDate createDate, LocalDate expiryDate, Double price) {
        super(name, createDate, expiryDate, price);
    }
}
