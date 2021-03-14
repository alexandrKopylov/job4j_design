package ru.job4j.tree;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TreeTwoTest {

    @Test
    public void whenTreeDepth3has3childOn1Lavel() {
        TreeTwo<Integer> tree = new TreeTwo<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.isBinary(),
                is(false)
        );
    }

    @Test
    public void whenTreeDepth2has3childOn2Level() {
        TreeTwo<Integer> tree = new TreeTwo<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 4);
        tree.add(3, 5);
        tree.add(3, 6);
        assertThat(
                tree.isBinary(),
                is(false)
        );
    }

    @Test
    public void whenTreeDepth3() {
        TreeTwo<Integer> tree = new TreeTwo<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 4);
        tree.add(3, 5);
        tree.add(5, 6);
        tree.add(5, 7);
        assertThat(
                tree.isBinary(),
                is(true)
        );
    }

    @Test
    public void when1parent() {
        TreeTwo<Integer> tree = new TreeTwo<>(1);
        assertThat(
                tree.isBinary(),
                is(true)
        );
    }

    @Test
    public void when1parent1child() {
        TreeTwo<Integer> tree = new TreeTwo<>(1);
        tree.add(1, 2);
        assertThat(
                tree.isBinary(),
                is(true)
        );
    }

    @Test
    public void when1parent2child() {
        TreeTwo<Integer> tree = new TreeTwo<>(1);
        tree.add(1, 2);
        tree.add(1, 3);

        assertThat(
                tree.isBinary(),
                is(true)
        );
    }
}