package ru.job4j.zadanie;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {
    @Test
    public void whenCurrentMoreThenPrevios() {

        List<Analize.User> previous = new ArrayList<>();
        previous.add(new Analize.User(111, "Vasya"));
        previous.add(new Analize.User(222, "Kostya"));
        previous.add(new Analize.User(333, "Dima"));

        List<Analize.User> current = new ArrayList<>(previous);
        current.add(new Analize.User(444, "Vova"));

        Analize analize = new Analize();
        Analize.Info info  = analize.diff(previous, current);
        assertThat(info.added, is(1));
        assertThat(info.deleted, is(0));
        assertThat(info.changed, is(0));

    }
    @Test
    public void whenPreviosMoreThenCurrent() {

        List<Analize.User> previous = new ArrayList<>();
        previous.add(new Analize.User(111, "Vasya"));
        previous.add(new Analize.User(222, "Kostya"));
        previous.add(new Analize.User(333, "Dima"));

        List<Analize.User> current = new ArrayList<>(previous);
        current.remove(0);

        Analize analize = new Analize();
        Analize.Info info  = analize.diff(previous, current);
        assertThat(info.added, is(0));
        assertThat(info.deleted, is(1));
        assertThat(info.changed, is(0));

    }

    @Test
    public void whenChangeTwoName() {

        List<Analize.User> previous = new ArrayList<>();
        previous.add(new Analize.User(111, "Vasya"));
        previous.add(new Analize.User(222, "Kostya"));
        previous.add(new Analize.User(333, "Dima"));

        List<Analize.User> current = new ArrayList<>();
        current.add(new Analize.User(111, "Masha"));
        current.add(new Analize.User(222, "Alena"));
        current.add(new Analize.User(333, "Dima"));

        Analize analize = new Analize();
        Analize.Info info  = analize.diff(previous, current);
        assertThat(info.added, is(0));
        assertThat(info.deleted, is(0));
        assertThat(info.changed, is(2));

    }


}