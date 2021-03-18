package ru.job4j.tree;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenAddDublicate() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 2);
        tree.add(1, 2);
        assertThat(
                tree.size,
                is(2)
        );
    }

    @Test
    public void whenTreeDepth3has3childOn1Lavel() {
        Tree<Integer> tree = new Tree<>(1);
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
        Tree<Integer> tree = new Tree<>(1);
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
        Tree<Integer> tree = new Tree<>(1);
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
        Tree<Integer> tree = new Tree<>(1);
        assertThat(
                tree.isBinary(),
                is(true)
        );
    }

    @Test
    public void when1parent1child() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.isBinary(),
                is(true)
        );
    }

    @Test
    public void when1parent2child() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);

        assertThat(
                tree.isBinary(),
                is(true)
        );
    }
    
    
    
}