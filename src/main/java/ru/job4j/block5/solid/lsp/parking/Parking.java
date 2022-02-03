package ru.job4j.block5.solid.lsp.parking;

import ru.job4j.block5.solid.lsp.parking.model.Car;

public interface Parking {
    boolean accept(Car car);

}
