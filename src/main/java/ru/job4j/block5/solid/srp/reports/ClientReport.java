package ru.job4j.block5.solid.srp.reports;

public class ClientReport {

    public Report getReport(MemStore store, ReportType reportType, Currency currency) {
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
                report = new ReportBookkeeping(store, currency);
                break;
            default:
                throw new IllegalArgumentException("unknown reportType");
        }
        return report;
    }
}
