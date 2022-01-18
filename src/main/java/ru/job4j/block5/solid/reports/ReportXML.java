package ru.job4j.block5.solid.reports;

import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.function.Predicate;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.annotation.*;

public class ReportXML implements Report {
    private Store store;

    public ReportXML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = "";
        xml = listToXml(store.findBy(filter));
        return xml;
    }


    private String listToXml(List<Employee> employees) {
        StringBuilder strb = new StringBuilder();
        JAXBContext context = null;
        Marshaller marshaller = null;
        try {
            context = JAXBContext.newInstance(Employees.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try (var writer = new StringWriter()) {
            try {
                marshaller.marshal(new Employees(employees), writer);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            strb.append(writer.getBuffer().toString());
        } catch (IOException e) {
           e.printStackTrace();
        }
        return strb.toString();
    }


    @XmlRootElement(name = "employeesList")
    public static class Employees {

        private List<Employee> empList;

        public Employees() {
        }

        public Employees(List<Employee> empList) {
            this.empList = empList;
        }

        public List<Employee> getEmpList() {
            return empList;
        }

        public void setEmpList(List<Employee> empList) {
            this.empList = empList;
        }
    }
}
