package ru.job4j.block5.solid.lsp.foodstorage.model;

import java.time.LocalDateTime;

public class Milk extends Food {

    public Milk(String name, LocalDateTime createDate, LocalDateTime expiryDate, Double price, Double discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
