package ru.job4j.block5.solid.srp.reports;

import java.util.Calendar;

public class ClientReport {

    public Report getReport(MemStore store, ReportType reportType) {
        Report report;
        switch (reportType) {
            case HR:
                report = new ReportHR(store);
                break;
            case OLD:
                report = new ReportEngine(store);
                break;
            case PROGRAMMER:
                report = new ReportProgrammer(store);
                break;
            case  BOOKKEEPING:
                report = new ReportBookkeeping(store);
                break;
            default:
                throw new IllegalArgumentException("unknown reportType");
        }
        return report;
    }

    public static void main(String[] args) {
        ClientReport clientReport = new ClientReport();
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();

        store.add(new Employee("Ivan", now, now, 100));
        store.add(new Employee("Fedot", now, now, 35));
        store.add(new Employee("Albert", now, now, 115));
        store.add(new Employee("Sasha", now, now, 85));
        store.add(new Employee("Kostya", now, now, 77));


        Report engine = clientReport.getReport(store, ReportType.BOOKKEEPING);
        System.out.println(engine.generate(em -> em.getSalary() >= 50));
    }
}
