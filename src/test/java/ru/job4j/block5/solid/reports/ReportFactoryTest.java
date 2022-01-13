package ru.job4j.block5.solid.reports;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportFactoryTest {

    @Test
    public void whenReportXML() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);

        Report engine = ReportFactory.getReport(store, ReportType.XML, Currency.RUB);
        StringBuilder expect = new StringBuilder()
             .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
             .append("\n")
                .append("<employee name=\"")
                .append(worker.getName())
                .append("\" hired=\"")
                .append(ReportXML.toLocalDateTime(now))
                .append("+05:00")
                .append("\" fired=\"")
                .append(ReportXML.toLocalDateTime(now))
                .append("+05:00")
                .append("\" salary=\"")
                .append(worker.getSalary())
                .append("\"/>")
                .append("\n")
                .append(System.lineSeparator());
       assertThat(engine.generate(em -> true), is(expect.toString()));
    }


    @Test
    public void whenReportJSON() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);

        Report engine = ReportFactory.getReport(store, ReportType.JSON, Currency.RUB);
        StringBuilder expect = new StringBuilder()
                .append("{\"name\":\"")
                .append(worker.getName())
                .append("\",\"hired\":{\"year\":")
                .append(now.get(Calendar.YEAR))
                .append(",\"month\":")
                .append(now.get(Calendar.MONTH))
                .append(",\"dayOfMonth\":")
                .append(now.get(Calendar.DAY_OF_MONTH))
                .append(",\"hourOfDay\":")
                .append(now.get(Calendar.HOUR_OF_DAY))
                .append(",\"minute\":")
                .append(now.get(Calendar.MINUTE))
                .append(",\"second\":")
                .append(now.get(Calendar.SECOND))
                .append("},\"fired\":{\"year\":")
                .append(now.get(Calendar.YEAR))
                .append(",\"month\":")
                .append(now.get(Calendar.MONTH))
                .append(",\"dayOfMonth\":")
                .append(now.get(Calendar.DAY_OF_MONTH))
                .append(",\"hourOfDay\":")
                .append(now.get(Calendar.HOUR_OF_DAY))
                .append(",\"minute\":")
                .append(now.get(Calendar.MINUTE))
                .append(",\"second\":")
                .append(now.get(Calendar.SECOND))
                .append("},\"salary\":")
                .append(worker.getSalary())
                .append("}")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenOldGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);

        Report engine = ReportFactory.getReport(store, ReportType.OLD, Currency.RUB);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportHrGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Employee worker1 = new Employee("Fedot", now, now, 35);
        store.add(worker1);
        Employee worker2 = new Employee("Albert", now, now, 115);
        store.add(worker2);

        Report engine = ReportFactory.getReport(store, ReportType.HR, Currency.RUB);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ; ").append(worker2.getSalary())
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ; ").append(worker.getSalary())
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ; ").append(worker1.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportProgrammerGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);

        Report engine = ReportFactory.getReport(store, ReportType.PROGRAMMER, Currency.RUB);
        StringBuilder expect = new StringBuilder()
                .append(" <!DOCTYPE html>")
                .append("<html>")
                .append(" <head>")
                .append(" <meta charset=\"utf-8\">")
                .append("<title>ReportHTML/title>")
                .append(" </head>")
                .append("<body>")
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("  </body> ")
                .append(" </html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportBookkeepingSalaryInEUR() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);

        Report engine = ReportFactory.getReport(store, ReportType.BOOKKEEPING, Currency.EUR);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append("1.1904761904761905").append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportBookkeepingSalaryInUSD() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);

        Report engine = ReportFactory.getReport(store, ReportType.BOOKKEEPING, Currency.USD);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append("1.3513513513513513").append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}