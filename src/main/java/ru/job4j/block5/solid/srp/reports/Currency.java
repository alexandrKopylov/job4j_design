package ru.job4j.block5.solid.srp.reports;

public enum Currency {
    RUB(1.0), EUR(84.0), USD(74.0);

    private double value;

    Currency(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
