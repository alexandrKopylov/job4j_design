package ru.job4j.block5.solid.lsp.foodstorage;

import org.junit.Test;
import ru.job4j.block5.solid.lsp.foodstorage.model.Bread;
import ru.job4j.block5.solid.lsp.foodstorage.model.Food;
import ru.job4j.block5.solid.lsp.foodstorage.model.Milk;
import ru.job4j.block5.solid.lsp.foodstorage.store.Shop;
import ru.job4j.block5.solid.lsp.foodstorage.store.Store;
import ru.job4j.block5.solid.lsp.foodstorage.store.Trash;
import ru.job4j.block5.solid.lsp.foodstorage.store.Warehouse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControllQualityTest {
    @Test
    public void whenFoodToWarehouse() {
        Store shop = new Shop();
        Store trash = new Trash();
        Store warehouse = new Warehouse();
        List<Store> storeList = Arrays.asList(shop, trash, warehouse);

        LocalDate createDate = LocalDate.now().minusDays(1);
        LocalDate expiryDate = createDate.plusDays(10);
        List<Food> foods = Arrays.asList(new Milk("Молоко", createDate, expiryDate, 60.0));
        ControllQuality cq = new ControllQuality(storeList);
        cq.sortFood(foods);
        assertThat(warehouse.findBy(x -> true), is(foods));
    }

    @Test
    public void whenFoodToShop() {
        Store shop = new Shop();
        Store trash = new Trash();
        Store warehouse = new Warehouse();
        List<Store> storeList = Arrays.asList(shop, trash, warehouse);

        LocalDate createDate = LocalDate.now().minusDays(5);
        LocalDate expiryDate = createDate.plusDays(10);
        List<Food> foods = Arrays.asList(new Bread("Хлеб", createDate, expiryDate, 25.0));
        ControllQuality cq = new ControllQuality(storeList);
        cq.sortFood(foods);
        assertThat(shop.findBy(x -> true), is(foods));
    }

    @Test
    public void whenFoodToShopWithDiscount() {
        Store shop = new Shop();
        Store trash = new Trash();
        Store warehouse = new Warehouse();
        List<Store> storeList = Arrays.asList(shop, trash, warehouse);

        LocalDate createDate = LocalDate.now().minusDays(9);
        LocalDate expiryDate = createDate.plusDays(10);
        Food bread = new Bread("Хлеб", createDate, expiryDate, 100.0);
        assertThat(bread.getDiscount(), is(0.0));

        List<Food> foods = new ArrayList<>();
        foods.add(bread);
        ControllQuality cq = new ControllQuality(storeList);
        cq.sortFood(foods);
        assertThat(shop.findBy(x -> true).get(0).getDiscount(), is(15.0));
    }

    @Test
    public void whenFoodToTrash() {
        Store shop = new Shop();
        Store trash = new Trash();
        Store warehouse = new Warehouse();
        List<Store> storeList = Arrays.asList(shop, trash, warehouse);

        LocalDate createDate = LocalDate.now().minusDays(10);
        LocalDate expiryDate = createDate.plusDays(8);
        List<Food> foods = Arrays.asList(new Bread("Хлеб", createDate, expiryDate, 25.0));
        ControllQuality cq = new ControllQuality(storeList);
        cq.sortFood(foods);
        assertThat(trash.findBy(x -> true), is(foods));
    }
}