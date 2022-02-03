package ru.job4j.block5.solid.lsp.parking;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.block5.solid.lsp.parking.model.Lorry;
import ru.job4j.block5.solid.lsp.parking.model.Sedan;

public class CarParkingTest {
    @Ignore
    @Test
    public void createParkingSedan2placeLorry1place() {
        boolean bool;
        CarParking carParking = new CarParking(2, 1);

        bool = carParking.accept(new Sedan());
        Assert.assertTrue(Boolean.toString(bool), true);

        bool = carParking.accept(new Sedan());
        Assert.assertTrue(Boolean.toString(bool), true);

        bool = carParking.accept(new Sedan());
        Assert.assertFalse(Boolean.toString(bool), false);

        bool = carParking.accept(new Lorry(4));
        Assert.assertTrue(Boolean.toString(bool), true);

        bool = carParking.accept(new Lorry(3));
        Assert.assertFalse(Boolean.toString(bool), false);
    }

    @Ignore
    @Test
    public void createParkingSedan2placeAndLorry1PlaceForTwoLorrys() {
        boolean bool;
        CarParking carParking = new CarParking(2, 1);

        bool = carParking.accept(new Lorry(4));
        Assert.assertTrue(Boolean.toString(bool), true);

        bool = carParking.accept(new Lorry(3));
        Assert.assertFalse(Boolean.toString(bool), false);

        bool = carParking.accept(new Lorry(2));
        Assert.assertTrue(Boolean.toString(bool), true);

        bool = carParking.accept(new Lorry(1));
        Assert.assertFalse(Boolean.toString(bool), false);
    }
}