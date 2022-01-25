package ru.job4j.block5.solid.lsp.foodstorage.model;

import java.util.Calendar;
import java.util.Date;

public class Food {
    String name;
    Calendar createDate;
    Calendar expiryDate;
    Double price;
    Double discount;

    public Food(String name, Calendar createDate, Calendar expiryDate, Double price, Double discount) {
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

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
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
                + ", expiryDate=" + createDate.getTime()
                + ", createDate=" + expiryDate.getTime()
                + ", price=" + price
                + ", discount=" + discount + '}';
    }
}
