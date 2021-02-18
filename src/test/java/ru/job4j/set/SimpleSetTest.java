package ru.job4j.set;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddDublicateInSet() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(3);
        simpleSet.add(1);
        simpleSet.add(2);
        List<Integer> result = new ArrayList<>();
        for (Integer number: simpleSet) {
            result.add(number);
        }
        assertThat(Arrays.asList(1, 2, 3), is(result));
    }


}