package ru.job4j.block5.solid.reports;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);
}
