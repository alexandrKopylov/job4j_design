package ru.job4j.block5.solid.reports;

import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.function.Predicate;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;

public class ReportXML implements Report {
    private Store store;

    public ReportXML(Store store) {
        this.store = store;
    }


    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(employee, writer);
                String result = writer.getBuffer().toString();
                text.append(result)
                        .append(System.lineSeparator());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return text.toString();
    }

    public static LocalDateTime toLocalDateTime(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        TimeZone tz = calendar.getTimeZone();
        ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
        return LocalDateTime.ofInstant(calendar.toInstant(), zid);
    }
}
