package ru.job4j.block5.solid.lsp.foodstorage.store;

import ru.job4j.block5.solid.lsp.foodstorage.model.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Predicate;

public interface Store {

    List<Food> findBy(Predicate<Food> filter);

    boolean add(Food food);

    /**
     * @param create - createDate
     * @param expiry - expiryDate
     *               now - currentTime
     *               difBeetwinCreateAndExpiry - разница между  createDate и expiryDate
     *               difBeetwinNowAndCreate - разница между currentTime  и expiryDate
     * @return
     */
    default double expirationPercent(LocalDate create, LocalDate expiry) {
        LocalDate now = LocalDate.now();
        long difBeetwinCreateAndExpiry = create.until(expiry, ChronoUnit.DAYS);
        long difBeetwinNowAndCreate = create.until(now, ChronoUnit.DAYS);

        return (double) difBeetwinNowAndCreate / difBeetwinCreateAndExpiry * 100;
    }
}