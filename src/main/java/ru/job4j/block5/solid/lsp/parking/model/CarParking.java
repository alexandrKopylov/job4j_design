package ru.job4j.block5.solid.lsp.parking.model;

import java.util.ArrayList;
import java.util.List;

public class CarParking implements Parking {
    private int measureSedans;
    private int measureLorrys;

    private final List<Car> lorrys = new ArrayList<>();
    private final List<Car> sedans = new ArrayList<>();

    public CarParking(int measureSedans, int measureLorrys) {
        this.measureSedans = measureSedans;
        this.measureLorrys = measureLorrys;

    }

    @Override
    public boolean accept(Car car) {
        return false;
    }
}
