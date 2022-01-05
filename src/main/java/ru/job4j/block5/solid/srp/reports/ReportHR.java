package ru.job4j.block5.solid.srp.reports;

import java.util.Comparator;
import java.util.function.Predicate;


public class ReportHR implements Report {
    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary").append(System.lineSeparator());

        store.findBy(filter).stream().sorted(new EmploeeComparator())
                .map(x -> x.getName() + " ; " + x.getSalary() + System.lineSeparator())
                .forEach(text::append);
        return text.toString();
    }

    class EmploeeComparator implements Comparator<Employee> {
        public int compare(Employee a, Employee b) {
            return (int) (b.getSalary() - a.getSalary());
        }
    }
}
