package ru.job4j.block5.solid.srp.reports;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportHR implements Report {
    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }



    @Override
    public String generate(Predicate<Employee> filter) {

        List<Employee> list = store.findBy(filter);

        StringBuilder text = new StringBuilder();

        text.append("Name; Salary").append(System.lineSeparator());

        list.stream().sorted(new EmploeeComparator())
                .map(x -> x.getName() + " ; " + x.getSalary() + "/n")
                .forEach(text::append);
        return text.toString();
    }

    class EmploeeComparator implements Comparator<Employee> {
        public int compare(Employee a, Employee b) {
            return (int) (a.getSalary() - b.getSalary());
        }
    }


}
