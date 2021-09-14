package ru.job4j.bloc1.set;

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
        for (Integer number : simpleSet) {
            result.add(number);
        }
        assertThat(Arrays.asList(1, 2, 3), is(result));
    }

    @Test
    public void whenAddNullElement() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add(null);
        simpleSet.add(null);
        simpleSet.add(null);

        List<String> result = new ArrayList<>();
        for (String str : simpleSet) {
            result.add(str);
        }
        List<String> actual = new ArrayList<>();
        actual.add(null);
        assertThat(actual, is(result));
    }

    @Test
    public void whenAdd1null2null3ShouldGe1null2null3() {
        List<Integer> expected = Arrays.asList(1, null, 2, null, 3);
        SimpleSet<Integer> set = new SimpleSet<>();
        expected.forEach(set::add);
        List<Integer> actual = new ArrayList<>();
        for (Integer value : set) {
            actual.add(value);
        }
        List<Integer> expected2 = Arrays.asList(1, null, 2, 3);
        assertThat(actual, is(expected2));
    }





}