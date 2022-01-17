package ru.job4j.block5.solid.reports;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class ReportJSON implements Report {
    private Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {

        final Gson gson = new GsonBuilder().create();
        StringBuilder textJSON = new StringBuilder();
        store.findBy(filter).forEach(x -> textJSON.append(gson.toJson(x)).append(System.lineSeparator()));
        return textJSON.toString();
    }

    public static void main(String[] args) {
        var store = new MemStore();

        store.add(new Employee("vasya", null, null, 111));
        store.add(new Employee("kuzya", null, null, 333));
        store.add(new Employee("fedya", null, null, 100));
        ReportJSON rj = new ReportJSON(store);
        System.out.println(rj.generate(x -> true));


    }
}
