package ru.job4j.block5.solid.reports;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ReportJSON implements Report {
    private Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employeeList = new ArrayList<>();
        final Gson gson = new GsonBuilder().create();
        store.findBy(filter).forEach(x -> employeeList.add(x));
        return  gson.toJson(employeeList);
    }
}
