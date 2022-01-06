package ru.job4j.block5.solid.srp.reports;

import java.util.function.Predicate;

public class ReportBookkeeping implements Report {
    private Store store;
    private Currency currency;

    public ReportBookkeeping(Store store, Currency currency) {
        this.store = store;
        this.currency = currency;
    }

    public double getCurrencyIndex() {
        double index;
        switch (currency) {
            case EUR:
                index = 84.0;
                break;
            case USD:
                index = 74.0;
                break;
            case RUB:
                index = 1.0;
                break;
            default:
                throw new IllegalArgumentException("unknown currency");
        }
        return index;
    }

    @Override
    public String generate(Predicate<Employee> filter) {

        double currencyIndex = getCurrencyIndex();
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() / currencyIndex).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
