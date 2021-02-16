package ru.job4j.list;


import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2 , 3, 4, 5));
        ListUtils.removeIf(input, x -> x > 3);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2 , 3, 4, 5));
        ListUtils.replaceIf(input, x -> x == 3, 333);
        assertThat(Arrays.asList(1, 2, 333 , 4 , 5), Is.is(input));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2 , 3, 4, 5));
        List<Integer> del = new ArrayList<>(Arrays.asList( 2 , 3, 4 ));
        ListUtils.removeAll(input,del);
        assertThat(Arrays.asList(1, 5), Is.is(input));
    }

}