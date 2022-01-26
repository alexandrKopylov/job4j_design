package ru.job4j.block5.solid.lsp.foodstorage.model;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public abstract class Food {
    String name;
    LocalDateTime createDate;
    LocalDateTime expiryDate;
    Double price;
    Double discount;

    public Food(String name, LocalDateTime createDate, LocalDateTime expiryDate, Double price, Double discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
