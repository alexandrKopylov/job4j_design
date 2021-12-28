package ru.job4j.block5.template;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ClassGeneratorTest {
    @Test
    public void whenTemplateWorkCorrect() {
        ClassGenerator cg = new ClassGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String result = cg.produce(template, map);
        Assert.assertThat(result, is("I am a Petr Arsentev, Who are you? "));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenBadTemplate() {
        ClassGenerator cg = new ClassGenerator();
        String template = "I am a {name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String result = cg.produce(template, map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenBadKeyInMap() {
        ClassGenerator cg = new ClassGenerator();
        String template = "I am a {name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("nam", "Petr Arsentev");
        map.put("subject", "you");
        String result = cg.produce(template, map);
    }
}