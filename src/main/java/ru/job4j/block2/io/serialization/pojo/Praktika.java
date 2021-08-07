package ru.job4j.block2.io.serialization.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "praktika")
public class Praktika {

    @XmlAttribute
    String factory ;
    int age ;

    public Praktika(){
    }

    public Praktika(String factory, int age) {
        this.factory = factory;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Praktika{" +
                "factory='" + factory + '\'' +
                ", age=" + age +
                '}';
    }
}
