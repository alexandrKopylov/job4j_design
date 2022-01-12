package ru.job4j.block5.solid.reports;

import java.util.function.Predicate;

public class ReportBookkeeping implements Report {
    private final Store store;
    private final Currency currency;

    public ReportBookkeeping(Store store, Currency currency) {
        this.store = store;
        this.currency = currency;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() / currency.getValue()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
