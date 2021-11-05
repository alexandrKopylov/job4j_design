package ru.job4j.block2.io.serialization.pojo;

import java.io.StringReader;
import java.util.Arrays;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;


@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @XmlAttribute
    private boolean isday;

    @XmlAttribute
    private int age;

    @XmlAttribute
    private String name;


    private Praktika praktika;

    String[] language;

    public Student() {
    }

    public Student(boolean isday, int age, String name, Praktika praktika, String... language) {
        this.isday = isday;
        this.age = age;
        this.name = name;
        this.praktika = praktika;
        this.language = language;
    }


    @Override
    public String toString() {
        return "Student{"
                + "isday=" + isday
                + ", age=" + age
                + ", name='" + name + '\''
                + ", praktika=" + praktika
                + ", language=" + Arrays.toString(language)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {

        final Student stud = new Student(true, 22, "Sasha", new Praktika("kmz", 22), "java", "python", "c++");

        JAXBContext context = JAXBContext.newInstance(Student.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(stud, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                +
                "<student isday=\"true\" age=\"22\" name=\"Sasha\">\n"
                +
                "    <praktika factory=\"kmz\"/>\n"
                +
                "    <language>java</language>\n"
                +
                "    <language>python</language>\n"
                +
                "    <language>c++</language>\n"
                +
                "</student>\n";
        
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
          
            Student result = (Student) unmarshaller.unmarshal(reader);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}