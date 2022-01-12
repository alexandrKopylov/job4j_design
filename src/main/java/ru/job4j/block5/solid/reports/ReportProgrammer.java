package ru.job4j.block5.solid.reports;

import java.util.function.Predicate;

public class ReportProgrammer implements Report {
    private Store store;

    public ReportProgrammer(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();

        text.append(" <!DOCTYPE html>")
                .append("<html>")
                .append(" <head>")
                .append(" <meta charset=\"utf-8\">")
                .append("<title>ReportHTML/title>")
                .append(" </head>")
                .append("<body>")

                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        text.append("  </body> ")
                .append(" </html>");
        return text.toString();
    }
}
