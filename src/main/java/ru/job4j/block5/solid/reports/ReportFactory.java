package ru.job4j.block5.solid.reports;

public class ReportFactory {

    public static Report getReport(Store store, ReportType reportType, Currency currency) {
        Report report;
        switch (reportType) {
            case XML:
                report = new ReportXML(store);
                break;
            case JSON:
                report = new ReportJSON(store);
                break;
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
