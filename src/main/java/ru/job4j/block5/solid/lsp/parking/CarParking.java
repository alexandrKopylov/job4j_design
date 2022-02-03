package ru.job4j.block5.solid.lsp.parking;

import ru.job4j.block5.solid.lsp.parking.model.Car;
import ru.job4j.block5.solid.lsp.parking.model.Lorry;
import ru.job4j.block5.solid.lsp.parking.model.Sedan;

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
        boolean bool = false;
        if (car.getSize() == Sedan.SIZE && sedans.size() < measureSedans) {
            sedans.add(car);
            bool = true;
        } else if (car.getSize() > Sedan.SIZE && lorrys.size() < measureLorrys) {
            lorrys.add(car);
            bool = true;
        } else if (measureSedans - sedans.size() >= car.getSize()) {
            for (int i = 0; i < car.getSize(); i++) {
                sedans.add(new Sedan());
            }
            bool = true;
        }
        return bool;
    }
}
