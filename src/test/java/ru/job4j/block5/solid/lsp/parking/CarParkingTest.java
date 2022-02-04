package ru.job4j.block5.solid.lsp.parking;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.block5.solid.lsp.parking.model.Lorry;
import ru.job4j.block5.solid.lsp.parking.model.Sedan;

public class CarParkingTest {
    @Test
    public void createParkingSedan2placeLorry1place() {
        CarParking carParking = new CarParking(2, 1);
        Assert.assertTrue(carParking.accept(new Sedan()));
        Assert.assertTrue(carParking.accept(new Sedan()));
        Assert.assertFalse(carParking.accept(new Sedan()));
        Assert.assertTrue(carParking.accept(new Lorry(4)));
        Assert.assertFalse(carParking.accept(new Lorry(4)));
    }

    @Test
    public void createParkingSedan2placeAndLorry1PlaceForTwoLorrys() {
        CarParking carParking = new CarParking(2, 1);
        Assert.assertTrue(carParking.accept(new Lorry(4)));
        Assert.assertFalse(carParking.accept(new Lorry(3)));
        Assert.assertTrue(carParking.accept(new Lorry(2)));
        Assert.assertFalse(carParking.accept(new Lorry(3)));
    }
}