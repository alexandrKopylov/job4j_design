package ru.job4j.block5.solid.lsp.foodstorage.model;

import java.time.LocalDate;

public abstract class Food {
    String name;
    LocalDate createDate;
    LocalDate expiryDate;
    Double price;
    Double discount = 0.0;

    public Food(String name, LocalDate createDate, LocalDate expiryDate, Double price) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", expiryDate=" + createDate
                + ", createDate=" + expiryDate
                + ", price=" + price
                + ", discount=" + discount + '}';
    }
}
